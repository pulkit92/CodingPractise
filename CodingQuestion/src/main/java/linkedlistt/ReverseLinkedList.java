package linkedlistt;

public class ReverseLinkedList {
  public static void main(String args[]) {
    ReverseLinkedList r = new ReverseLinkedList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    r.reverseList(head);
    r.print(head);
  }

  public void print(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }

  }

  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }
}