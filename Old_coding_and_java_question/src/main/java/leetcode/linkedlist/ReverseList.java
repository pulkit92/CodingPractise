package leetcode.linkedlist;

public class ReverseList {
	static ListNode head;

	public static void main(String args[]) {
		ReverseList a = new ReverseList();
		a.head = new ListNode(1);
		a.head.next = new ListNode(2);
		a.head.next.next = new ListNode(3);
		a.head.next.next.next = new ListNode(4);
		ListNode f = reverseList(head, null, null);
		print();
	}

	static void print() {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}
	
	static ListNode reverseList(ListNode curr, ListNode prev, ListNode next) {

		if (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			return reverseList(next, prev, next);

		}
		return prev;

	}

}
