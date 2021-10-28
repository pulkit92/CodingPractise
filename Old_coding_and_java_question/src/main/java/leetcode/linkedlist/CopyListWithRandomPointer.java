package leetcode.linkedlist;

public class CopyListWithRandomPointer {
	// static RandomListNode head;

	public RandomListNode copyRandomList(RandomListNode head) {
		// RandomListNode r = createRandom(head);
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode temp1 = curr.next;
			RandomListNode temp = new RandomListNode(curr.label);
			temp.next = temp1;
			curr.next = temp;
			curr = curr.next.next;

		}
		curr = head;
		while (curr != null) {
			if (curr.random != null)
				curr.next.random = curr.random.next;
			else
				curr.next.random = null;
			curr = curr.next.next;

		}
		RandomListNode copy = head.next;
		RandomListNode temp = copy;
		curr = head;
		// save the start of copied linked list
		// now separate the original list and copied list
		while (curr != null && temp != null) {
			curr.next = curr.next != null ? curr.next.next : curr.next;

			temp.next = temp.next != null ? temp.next.next : temp.next;
			curr = curr.next;
			temp = temp.next;
		}

		printlist(copy);
		return copy;

	}

	void printlist(RandomListNode r) {
		while (r != null) {
			System.out.println(
					r.label + "  DDD0   -> " + r.hashCode() + "  kjj  ->  " + r.next + "  Random ---> " + r.random);
			r = r.next;
		}
	}

	public RandomListNode createRandom(RandomListNode head) {
		if (head == null)
			return null;
		RandomListNode r = new RandomListNode(head.label);
		r.next = createRandom(head.next);
		return r;

	}

	public static void main(String args[]) {
		CopyListWithRandomPointer list = new CopyListWithRandomPointer();
		RandomListNode head = new RandomListNode(5);
		head.next = new RandomListNode(4);

		head.next.next = new RandomListNode(3);
		head.next.next.next = new RandomListNode(2);
		head.next.next.next.next = new RandomListNode(1);

		// Setting up random references.
		head.random = head.next.next;
		head.next.random = head.next.next.next;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next.next.next.next;
		head.next.next.next.next.random = head.next;
		// list.printlist(head);
		// System.out.println("nffhbfhf");
		RandomListNode m = list.copyRandomList(head);
		//list.printlist(m);
	}
}
