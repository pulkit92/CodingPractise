import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class DesignALeaderboard {
  Map<Integer, Integer> map = null;

  public DesignALeaderboard() {
    map = new HashMap<>();
  }

  public void addScore(int playerId, int score) {
    int prevScore = map.getOrDefault(playerId, 0);
    map.put(playerId, prevScore + score);
  }

  public int top(int K) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    Set<Integer> keys = map.keySet();
    for (int key : keys) {
      priorityQueue.offer(map.get(key));
      if (priorityQueue.size() > K) {
        priorityQueue.poll();
      }
    }
    int total = 0;
    while (!priorityQueue.isEmpty()) {
      total = total + priorityQueue.poll();
    }
    return total;
  }

  public void reset(int playerId) {
    map.remove(playerId);
  }

  public static void main(String args[]) {
    DesignALeaderboard leaderboard = new DesignALeaderboard();
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


