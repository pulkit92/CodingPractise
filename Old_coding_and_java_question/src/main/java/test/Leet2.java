package test;

public class Leet2 {
	public static void addTwoNumbers(ListNode l1, ListNode l2) {
		// l1 = reverse(l1);
		// l2 = reverse(l2);
		int sum = convert(l1) + convert(l2);
		// ListNode previous = new ListNode(sum % 10);

		for (int i = sum; i > 0; i = i / 10) {
			int r = i % 10;
			ListNode newnode = new ListNode(r);
			newnode.next = head3;
			head3 = newnode;

		}
		printList(head3);

	}
//Linked List Sum
	public static int convert(ListNode l1) {
		int n = 0;
		int i = 0;
		while (l1 != null) {
			n = (int) (l1.data * Math.pow(10, i)) + n;
			i++;
			l1 = l1.next;
		}
		return n;
	}

	static ListNode reverse(ListNode l) {
		ListNode current = l;
		ListNode previous = null;
		ListNode next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;

		}
		l = previous;
		// printList(l);
		return l;

	}

	static ListNode head, head2, head3, head4;

	static class ListNode {

		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		Leet2 list = new Leet2();
		list.head = new ListNode(2);
		list.head.next = new ListNode(4);
		list.head.next.next = new ListNode(3);

		list.head2 = new ListNode(5);
		list.head2.next = new ListNode(6);
		list.head2.next.next = new ListNode(4);

		addTwoNumbers(list.head, list.head2);

	}

	static void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}
}
