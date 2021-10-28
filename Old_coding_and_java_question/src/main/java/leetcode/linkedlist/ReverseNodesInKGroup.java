package leetcode.linkedlist;

public class ReverseNodesInKGroup {
	// 7 9 2 10 1 8 6
	// 2 9 7 10 1 8 6
	// 2 9 7 8 1 10 6
	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		ListNode prev = null;

		while (curr != null) {
			int i = 0;
			ListNode next = null;
			ListNode temp = null;
			while (curr != null && i < k) {
				next = curr.next;
				curr.next = temp;
				temp = curr;
				curr = next;
				i++;
			}
			if (prev == null) {
				prev = temp;
			}
			head = next;
			head.next = next;

			curr = head;
		}

		return prev;

	}

	static ListNode head;

	public static void main(String args[]) {
		ReverseNodesInKGroup a = new ReverseNodesInKGroup();
		a.head = new ListNode(7);
		a.head.next = new ListNode(9);
		a.head.next.next = new ListNode(2);
		a.head.next.next.next = new ListNode(10);
		a.head.next.next.next.next = new ListNode(1);
		a.head.next.next.next.next.next = new ListNode(8);

		a.head.next.next.next.next.next.next = new ListNode(6);

		ListNode f = reverseKGroup(head, 3);
		print(f);
		// print();
	}

	static void print(ListNode prev) {
		System.out.println();
		while (prev != null) {
			System.out.println(prev.val);

			prev = prev.next;
		}
		System.out.println();
	}
}
