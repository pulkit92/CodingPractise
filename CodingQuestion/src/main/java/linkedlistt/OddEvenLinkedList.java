package linkedlistt;

public class OddEvenLinkedList {
  public ListNode oddEvenList(ListNode head) {
    ListNode odd = null;
    ListNode even = null;
    if (head == null) {
      return head;
    }
    if (head.next == null) {
      return head;
    }
    odd = head;
    even = head.next;
   ListNode xeven = even;
    while ((odd != null && odd.next != null) || (even != null && even.next != null)) {
      if (odd != null && odd.next != null) {
        odd.next = odd.next.next;
      }
      if (even != null && even.next != null) {
        even.next = even.next.next;
      }

    }
    odd.next = xeven;
    return head;
  }

  public static void main(String args[]) {
    OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
    ListNode listNode = new ListNode(1);
    listNode.next = new ListNode(2);
    listNode.next.next = new ListNode(3);
    listNode.next.next.next = new ListNode(4);
    listNode.next.next.next.next = new ListNode(5);
    ListNode x = oddEvenLinkedList.oddEvenList(listNode);
    System.out.println(x);
  }
}
