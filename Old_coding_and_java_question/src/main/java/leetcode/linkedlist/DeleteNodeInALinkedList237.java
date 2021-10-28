package leetcode.linkedlist;

public class DeleteNodeInALinkedList237 {
	static ListNode head;

	public static void deleteNode(ListNode node) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.val == node.val) {
				temp = temp.next.next;
				break;
			}
			temp = temp.next;
		}
		
	}

	public static void main(String args[]) {
		DeleteNodeInALinkedList237 a = new DeleteNodeInALinkedList237();
		a.head = new ListNode(4);
		a.head.next = new ListNode(5);
		a.head.next.next = new ListNode(1);
		a.head.next.next.next = new ListNode(9);
		ListNode node = new ListNode(5);
		deleteNode(node);
		print();
	}

	static void print() {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
