package leetcode.linkedlist;

public class RemoveLinkedListElements {
	static ListNode head;

	public static ListNode removeElements(ListNode head, int val) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			if (curr.val == val) {
				if (curr.next == null) {
					if (prev == null)
						return null;

					prev.next = null;
				} else {
					if (prev == null)
						curr = curr.next;
					else
						prev.next = curr.next;
				}
			}
			prev = curr;
			curr = curr.next;
		}
		return head;
	}

	public static void main(String args[]) {
		RemoveLinkedListElements a = new RemoveLinkedListElements();
		a.head = new ListNode(1);
		a.head.next = new ListNode(1);
		removeElements(head, 1);
		print();
	}

	static void print() {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
