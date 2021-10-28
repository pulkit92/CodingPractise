package leetcode;

public class SwapNodesInPairs24 {
	static ListNode l1;

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static ListNode swapPairs(ListNode head) {

		// If linked list is empty or there is only one node in list
		if (head == null || head.next == null) {
			return head;
		}

		// Initialize previous and current pointers
		ListNode prev = head;
		ListNode curr = head.next;

		head = curr; // Change head before proceeeding

		// Traverse the list
		while (true) {
			ListNode next = curr.next;
			curr.next = prev; // Change next of current as previous node

			// If next NULL or next is the last node
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			// Change next of previous to next next
			prev.next = next.next;

			// Update previous and curr
			prev = next;
			curr = prev.next;
		}
		return head;
	}

	public static void main(String[] args) {

		SwapNodesInPairs24 li = new SwapNodesInPairs24();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);

		li.printList(l);

		System.out.print("\n Sorted Linked List is: \n");
		swapPairs(l);
		li.printList(l);
	}

	void printList(ListNode headref) {
		while (headref != null) {
			System.out.print(headref.val + " ");
			headref = headref.next;
		}
	}

}
