import java.util.HashMap;

public class DesignALeaderBoard3 {

  class Node{
    int id;
    int score;
    Node prev;
    Node next;

    public Node(){}
    public Node(int id, int score){
      this.id = id;
      this.score = score;
    }
  }

  HashMap<Integer, Node> ref;
  Node head = new Node();
  Node tail = new Node();

  public void removeNode(Node node){
    Node nPrev = node.prev;
    Node nNext = node.next;
    nPrev.next = nNext;
    nNext.prev = nPrev;
  }

  public void addToTail(Node node){
    Node prevLast = tail.prev;
    node.prev = prevLast;
    prevLast.next = node;

    node.next = tail;
    tail.prev = node;
  }

  public void insertNode(Node node){
    Node curr = tail.prev;
    while(curr != head){
      if(curr.score > node.score) break;
      curr = curr.prev;
    }
    node.prev = curr;
    node.next = curr.next;
    curr.next.prev = node;
    curr.next = node;
  }

  public DesignALeaderBoard3() {
    ref = new HashMap<Integer, Node>();
    head.next = tail;
    tail.prev = head;
  }

  public void addScore(int playerId, int score) {
    if(!ref.containsKey(playerId)){
      Node node = new Node(playerId, 0);
      ref.put(playerId, node);
      addToTail(node);
    }
    Node temp = ref.get(playerId);
    removeNode(temp);
    temp.score += score;
    insertNode(temp);
  }

  public int top(int K) {
    int sum = 0;
    Node temp = head.next;
    int index = 0;
    while(temp != tail && index < K){
      sum += temp.score;
      temp = temp.next;
      index++;
    }
    return sum;
  }

  public void reset(int playerId) {
    Node node = ref.get(playerId);
    removeNode(node);
    node.score = 0;
    addToTail(node);
  }
  public static void main(String args[]) {
    DesignALeaderBoard3 leaderboard = new DesignALeaderBoard3();
    leaderboard.addScore(1, 73);   // leaderboard = [[1,73]];
    leaderboard.addScore(2, 56);   // leaderboard = [[1,73],[2,56]];
    leaderboard.addScore(3, 39);   // leaderboard = [[1,73],[2,56],[3,39]];
    leaderboard.addScore(4, 51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
    leaderboard.addScore(5, 4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
    System.out.println(leaderboard.top(1));           // returns 73;
    leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
    leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
    leaderboard.addScore(2, 51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
    System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;
  }
}