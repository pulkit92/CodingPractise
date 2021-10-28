package linkedlistt;

public class MiddleofLinkedList {
  public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && slow != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public static void main(String args[]) {
    MiddleofLinkedList r = new MiddleofLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);

    ListNode x = r.middleNode(head);
    r.print(x);
  }

  public void print(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }
  }
}
