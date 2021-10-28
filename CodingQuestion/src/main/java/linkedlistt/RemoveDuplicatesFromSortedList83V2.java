package linkedlistt;

public class RemoveDuplicatesFromSortedList83V2 {
  static ListNode head;

  public ListNode deleteDuplicates(ListNode head) {
    ListNode temp=head;
    while (temp != null && temp.next != null) {
      if (temp.val == temp.next.val) {
        if (temp.next.next == null) {
          temp.next = null;
        } else {
          temp.next = temp.next.next;
        }

      } else {
        temp = temp.next;
      }
    }
    return head;
  }

  public static void main(String[] args) {
    RemoveDuplicatesFromSortedList83V2 l = new RemoveDuplicatesFromSortedList83V2();
    l.head = new ListNode(1);
    l.head.next = new ListNode(3);
    l.head.next.next = new ListNode(3);
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

