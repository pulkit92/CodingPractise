package linkedlistt;

public class SwapNodesInPairs24 {
  static ListNode head;

  public ListNode swapPairs(ListNode head) {
    ListNode cur = head;
    while (cur != null && cur.next != null) {
      ListNode temp = cur.next.next;
      cur.next=cur;
      cur=cur.next;
      cur.next=temp;

    }
    return head;
  }

  public static void main(String[] args) {
    SwapNodesInPairs24 l = new SwapNodesInPairs24();
    l.head = new ListNode(1);
    l.head.next = new ListNode(2);
    l.head.next.next = new ListNode(3);
    l.head.next.next.next = new ListNode(4);
    l.swapPairs(head);
    print();
  }

  static void print() {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
