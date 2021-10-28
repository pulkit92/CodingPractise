package linkedlistt;

public class SwapNodesInPairs {
  public static void main(String args[]) {
    SwapNodesInPairs r = new SwapNodesInPairs();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    r.print(r.swapPairs(head));
  }

  public void print(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }

  }

  /*
    public linkedlistt.ListNode swapPairs(linkedlistt.ListNode head) {
      if (head == null || head.next == null) {
        return head;
      }
      linkedlistt.ListNode cur = head.next;
      linkedlistt.ListNode cur1 = head;
      linkedlistt.ListNode cur2 = head.next;
      linkedlistt.ListNode prev = null;

      while (cur1 != null && cur2 != null) {
        linkedlistt.ListNode temp = cur1.next;
        cur1.next = cur2.next;
        temp.next = cur1;
        if (prev != null) {
          prev.next = temp;
        }
        prev = cur1;
        if (cur1.next == null) {
          break;
        }
        cur2 = cur1.next.next;
        cur1 = cur1.next;

      }
      return cur;
    }
  */
  public ListNode swapPairs(ListNode head) {
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode n = head.next;
    head.next = swapPairs(head.next.next);
    n.next = head;
    return n;
  }
}
