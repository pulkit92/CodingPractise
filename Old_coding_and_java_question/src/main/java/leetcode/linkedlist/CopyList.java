package leetcode.linkedlist;

public class CopyList {
	static ListNode head;

	public static void main(String args[]) {
		CopyList a = new CopyList();
		a.head = new ListNode(1);
		a.head.next = new ListNode(2);
		a.head.next.next = new ListNode(3);
		a.head.next.next.next = new ListNode(4);
		ListNode f = reverseList(head);
	}

	private static ListNode reverseList(ListNode head2) {
		ListNode temp =null;
		while (head2 != null) {
			 temp = head2.next;
			ListNode l = new ListNode(head2.val);
			l.next = temp;
			temp = l;
			temp = temp.next;

			head2 = head2.next;

		}
		return temp;
	}
}
