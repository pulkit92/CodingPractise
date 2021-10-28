package linkedlistt;

import java.util.HashMap;

public class FirstUnique {
  LinkedList head;
  LinkedList tail;
  HashMap<Integer, LinkedList> map;

  public FirstUnique(int[] nums) {
    map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      this.add(nums[i]);
    }
  }

  public int showFirstUnique() {
    if (head != null) {
      return head.value;
    }
    return -1;

  }

  public void add(int value) {
    if (!map.containsKey(value)) {
      LinkedList node = new LinkedList(value);
      if (head == null) {
        head = node;
        tail = head;
      } else {
        node.right = head;
        head.left = node;
        head = node;
      }
      map.put(value, node);
    } else {
      LinkedList linkedList = map.get(value);
      remove(linkedList);
    }
  }

  public void remove(LinkedList node) {
    if (node.left != null) {
      node.left.right = node.right;
    } else {
      head = node.right;
    }

    if (node.right != null) {
      node.right.left = node.left;
    } else {
      tail = node.left;
    }
  }

  public static void main(String args[]) {
    int a []=new int [23];
    for (int i=0;i<23;i++){
      a[i]=61;
    }
    FirstUnique firstUnique = new FirstUnique(a);
    System.out.println(firstUnique.showFirstUnique());// return -1
    firstUnique.add(4);            // the queue is now [7,7,7,7,7,7,7]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3]
    firstUnique.add(3);            // the queue is now [7,7,7,7,7,7,7,3,3]
    firstUnique.add(7);            // the queue is now [7,7,7,7,7,7,7,3,3,7]
    firstUnique.add(17);           // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
    System.out.println(firstUnique.showFirstUnique());
  }
}


class LinkedList {
  public LinkedList left;
  public LinkedList right;
  public int value;

  public LinkedList(int value) {
    this.value = value;
  }
}