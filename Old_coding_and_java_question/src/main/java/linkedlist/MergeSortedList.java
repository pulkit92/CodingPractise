package linkedlist;

public class MergeSortedList {
	static class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		/*
		 * The constructed linked list is: 10->12->11->11->12->11->10
		 */
		node l1 = new node(1);
		l1.next = new node(2);
		l1.next.next = new node(4);
		node l2 = new node(1);
		l2.next = new node(3);
		l2.next.next = new node(4);
		node[] lists = new node[2];
		mergeKLists(lists);

		node l3 = mergeTwoLists(l1, l2);
		print(l3);
	}

	public static void print(node l1) {
		while (l1 != null) {
			System.out.println(l1.val);
			l1 = l1.next;
		}
	}

	public static node mergeTwoLists(node l1, node l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		if (l1.val > l2.val) {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}

		else {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		}

	}

	public static node mergeKLists(node[] lists) {

		if (lists.length < 1)
			return null;
		if (lists.length == 1) {
			return lists[1];
		}
		if (lists.length == 2) {
			node n1 = lists[0];
			node n2 = lists[1];
			node l3 = mergeTwoLists(n1, n2);
			return l3;
		}

		if (lists.length > 2) {
			node n1 = lists[0];
			node n2 = lists[1];
			node l3 = mergeTwoLists(n1, n2);
			
			
		}

		return null;

	}
}
