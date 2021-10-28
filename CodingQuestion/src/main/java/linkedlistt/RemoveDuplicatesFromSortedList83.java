package linkedlistt;

public class RemoveDuplicatesFromSortedList83 {
  static ListNode head;

  public ListNode deleteDuplicates(ListNode head) {
    if (head != null && head.next != null) {
      if (head.val == head.next.val) {
        if (head.next.next == null) {
          head.next = null;
          return head;
        } else {
          head.next = head.next.next;
          deleteDuplicates(head);
        }
      } else {
        deleteDuplicates(head.next);
      }
    }
    return head;


  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedList83 l = new RemoveDuplicatesFromSortedList83();
    l.head = new ListNode(1);
    l.head.next = new ListNode(3);
    l.head.next.next = new ListNode(3);
    l.head.next.next.next = new ListNode(4);
    l.deleteDuplicates(head);
    print();
  }

  static void print() {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
