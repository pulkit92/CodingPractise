package lrucache;

import java.util.HashMap;
import java.util.Map;

class LRUCache1 {
  private final int capacity;
  private final Map<Integer, DoublyListNode> map;
  private DoublyListNode head;
  private DoublyListNode bottom;

  public LRUCache1(int capacity) {
    this.capacity = capacity;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DoublyListNode node = map.get(key);
      if (node.left == null) {
        return node.value;
      } else if (node.right == null) {
        removeAtEnd(node);
        addAtTop(node);
        return node.value;
      } else {
        removeAtEnd(node);
        addAtTop(node);
        return node.value;
      }
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      DoublyListNode d = map.get(key);
      d.value = value;
      removeAtEnd(d);
      addAtTop(d);
      map.put(key, d);
      return;
    }
    DoublyListNode doublyListNode = new DoublyListNode(key, value);
    if (map.size() >= capacity) {
      map.remove(bottom.key);
      removeAtEnd(bottom);
      addAtTop(doublyListNode);
      map.put(key, doublyListNode);
    } else {
      addAtTop(doublyListNode);
      map.put(key, doublyListNode);
    }
  }

  private void removeAtEnd(DoublyListNode doublyListNode) {

    if (doublyListNode.left != null) {
      doublyListNode.left.right = doublyListNode.right;
    } else {
      head = doublyListNode.right;
    }
    if (doublyListNode.right != null) {
      doublyListNode.right.left = doublyListNode.left;
    } else {
      bottom = doublyListNode.left;
    }
  }

  private void addAtTop(DoublyListNode doublyListNode) {
    if (head == null) {
      head = doublyListNode;
      bottom = doublyListNode;
      return;
    }
    doublyListNode.left = null;
    doublyListNode.right = head;
    head.left = doublyListNode;
    head = doublyListNode;

  }



  public static void main(String targs[]) {
    LRUCache1 cache = new LRUCache1(2);
    //  System.out.println(cache.get(2));     // returns -1 (not found)

    cache.put(2, 1);
    cache.put(1, 1);    // evicts key 2
    cache.put(2, 3);
    cache.put(4, 3);    // evicts key 1// evicts key 1
    System.out.println(cache.get(1));
    System.out.println(cache.get(2));

  }


}


class DoublyListNode {
  DoublyListNode left;
  DoublyListNode right;
  int value;
  int key;

  public DoublyListNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
 * obj.get(key); obj.put(key,value);
 */