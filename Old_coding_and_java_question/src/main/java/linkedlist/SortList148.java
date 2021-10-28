/*
package linkedlist;

import java.util.List;

public class SortList148 {
  public ListNode sortList(ListNode head) {
    ListNode zd=middleofLinkedList( head);
re
  }


  public static void main(String args[]) {
    SortList148 s = new SortList148();
    ListNode head = new ListNode(4);
    head.next = new ListNode(2);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(3);
    ListNode m = s.sortList(head);
  }

  ListNode middleofLinkedList(ListNode head) {
    ListNode slow = head;
    ListNode fast = null;
    while (slow != null) {
      fast = slow.next;
      if (fast != null) {
        slow = slow.next;
        fast = slow.next;
      }

    }
    return slow;
  }
}
*/
