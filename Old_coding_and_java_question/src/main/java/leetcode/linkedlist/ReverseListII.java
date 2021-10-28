package leetcode.linkedlist;

public class ReverseListII {
	public static ListNode reverseBetween(ListNode head, int m, int n) {

		// Empty list
		if (head == null) {
			return null;
		}

		// Move the two pointers until they reach the proper starting point
		// in the list.
		ListNode cur = head, prev = null;
		while (m > 1) {
			prev = cur;
			cur = cur.next;
			m--;
			n--;
		}

		// The two pointers that will fix the final connections.
		ListNode con = prev, tail = cur;

		// Iteratively reverse the nodes until n becomes 0.
		ListNode third = null;
		while (n > 0) {
			third = cur.next;
			cur.next = prev;
			prev = cur;
			cur = third;
			n--;
		}
		// Adjust the final connections as explained in the algorithm
		if (con != null) {
			con.next = prev;
		} else {
			head = prev;
		}

		tail.next = cur;
		return head;
	}

	static ListNode head;

	public static void main(String args[]) {
		ReverseListII a = new ReverseListII();
		a.head = new ListNode(7);
		a.head.next = new ListNode(9);
		a.head.next.next = new ListNode(2);
		a.head.next.next.next = new ListNode(10);
		a.head.next.next.next.next = new ListNode(1);
		a.head.next.next.next.next.next = new ListNode(8);

		a.head.next.next.next.next.next.next = new ListNode(6);

		ListNode f = reverseBetween(head, 2, 5);
		print(f);
		// print();
	}

	static void print() {
		while (head != null) {
			System.out.print(head.val);

			head = head.next;
		}
		System.out.println();

	}

	static void print(ListNode prev) {
		while (prev != null) {
			System.out.println(prev.val);

			prev = prev.next;
		}
		System.out.println();
	}
}
