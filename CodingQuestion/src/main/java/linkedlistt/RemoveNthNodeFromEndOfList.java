package linkedlistt;

public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode temp = new ListNode(0);
    temp.next = head;
    ListNode curr = temp;
    ListNode curr2 = temp;
    int i = 0;
    while (curr != null && i <= n) {
      curr = curr.next;
      i++;
    }
    while (curr != null) {
      curr2 = curr2.next;
      curr = curr.next;
    }

    curr2.next = curr2.next.next;

    return temp.next;
  }


  public static void main(String args[]) {
    RemoveNthNodeFromEndOfList r = new RemoveNthNodeFromEndOfList();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
  /*  head.next.next = new linkedlistt.ListNode(3);
    head.next.next.next = new linkedlistt.ListNode(4);
    head.next.next.next.next = new linkedlistt.ListNode(5);*/
    r.removeNthFromEnd(head, 2);
    r.print(head);
  }

  public void print(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }
  }
}
