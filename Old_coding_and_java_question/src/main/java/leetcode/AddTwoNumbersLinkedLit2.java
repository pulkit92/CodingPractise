package leetcode;

public class AddTwoNumbersLinkedLit2 {
	static ListNode l1, l2;

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/*int lenght1 = (lengthOfLinkedList(l1));
		int lenght2 = (lengthOfLinkedList(l2));
		if (lenght1 != lenght2) {
			int diff = Math.abs(lenght1 - lenght2);
			if (lenght1 > lenght2) {
				l2 = addNode(l2, diff);
			} else {
				l1 = addNode(l1, diff);

			}
		}*/

		return addLinkedList(l1, l2, 0);
	}

	public ListNode addLinkedList(ListNode l1, ListNode l2, int value) {
		if (l1 == null && l2 == null && value == 0)
			return null;

		if (l1 != null) {
			value = value + l1.val;
		}
		if (l2 != null) {
			value = value + l2.val;

		}

		ListNode n = new ListNode(value % 10);
		if (l1 != null || l2 != null) {
			n.next = addLinkedList((l1==null?null:l1.next), (l2==null?null:l2.next), value = value >=10 ? 1 : 0);

		}

		return n;

	}

/*	public ListNode addNode(ListNode l, int diff) {
		ListNode curr=l;
		while (diff > 0) {
			ListNode n = new ListNode(0);
			curr.next=n;
			curr=curr.next;
			diff--;
		}
		l.next=curr;
		return l;
	}
	
	public ListNode addafter(ListNode,int d) {
		ListNode n = new ListNode(d);
	}*/

	public int lengthOfLinkedList(ListNode l) {
		int count = 1;
		while (l.next != null) {
			l = l.next;
			count++;

		}

		return count;

	}

	public static void main(String[] args) {
		AddTwoNumbersLinkedLit2 list = new AddTwoNumbersLinkedLit2();

		// creating first list
		list.l1 = new ListNode(8);
		list.l1.next = new ListNode(9);
		list.l1.next.next = new ListNode(9);


		// System.out.print("First List is ");

		// creating seconnd list
		list.l2 = new ListNode(2);
	
		// System.out.print("Second List is ");

		// add the two lists and see the result
		ListNode rs = list.addTwoNumbers(l1, l2);
		printList(rs);
		// System.out.print("Resultant List is ");
	}

	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}
}
