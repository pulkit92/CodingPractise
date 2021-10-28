package leetcode;

public class RemoveNthnodefrolLast19 {
	static ListNode l1;

	static class ListNode {
		int val;
		ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		RemoveNthnodefrolLast19 list = new RemoveNthnodefrolLast19();

		// creating first list
		list.l1 = new ListNode(1);
		list.l1.next = new ListNode(2);
		list.l1.next.next = new ListNode(3);
		list.l1.next.next.next = new ListNode(4);
		list.l1.next.next.next.next = new ListNode(5);
	//removeNthFromEnd(l1, 2) ;
		// System.out.print("First List is ");

		// creating seconnd list

		// System.out.print("Second List is ");

		// add the two lists and see the result
		printList(removeNthFromEnd(l1, 2) );
		// System.out.print("Resultant List is ");
	}

	static void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println("");
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {

		 ListNode dummy = new ListNode(0);
		    dummy.next = head;
		    ListNode fast = dummy;
		    ListNode slow = dummy;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
	    return dummy.next;
		

	}
}
