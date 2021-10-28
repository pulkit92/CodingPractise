package linkedlistt;

public class SplitLinkedListInParts725 {
  static ListNode head;

  public ListNode[] splitListToParts(ListNode root, int k) {
    int x = getLength(root);
    ListNode[] out = new ListNode[k];
    if (x == 0) {
      return out;
    }
    int ans = x / k;
    int mod = x % k;
    ListNode temp = root;
    for (int i = 0; i < k; i++) {
      ListNode head = new ListNode(0), write = head;
      for (int j = 0; j < ans + (mod > i ? 1 : 0); j++) {
        write.next = new ListNode(temp.val);
        write = write.next;
        if (temp.next != null) {
          temp = temp.next;
        }
      }
      out[i]=head.next;
    }
    return out;
  }

  int getLength(ListNode temp) {
    int count = 0;
    while (temp != null) {
      temp = temp.next;
      count++;
    }
    return count;
  }

  public static void main(String[] args) {
    SplitLinkedListInParts725 l = new SplitLinkedListInParts725();
    l.head = new ListNode(1);
    l.head.next = new ListNode(3);
    l.head.next.next = new ListNode(3);
    l.head.next.next.next = new ListNode(4);
    l.splitListToParts(head, 3);
    print();
  }

  static void print() {
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}
