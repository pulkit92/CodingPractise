package leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists23 {
	public static ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return 1;
				else
					return -1;
			}
		});

		for (int i = 0; i < lists.length; i++) {
			ListNode k = lists[i];
			while (k != null) {
				queue.add(k.val);
				k = k.next;
			}

		}
		return merge(queue);

	}

	private static ListNode merge(PriorityQueue<Integer> queue) {
		if (!queue.isEmpty()) {
			ListNode k = new ListNode(queue.poll());
			k.next = merge(queue);
			return k;
		}
		return null;

	}

	static ListNode head;
	static ListNode head1;

	public static void main(String args[]) {
		MergeKSortedLists23 a = new MergeKSortedLists23();
		a.head = new ListNode(1);
		a.head.next = new ListNode(2);
		a.head.next.next = new ListNode(3);
		a.head.next.next.next = new ListNode(4);
		MergeKSortedLists23 b = new MergeKSortedLists23();

		a.head1 = new ListNode(7);
		a.head1.next = new ListNode(9);
		a.head1.next.next = new ListNode(2);
		a.head1.next.next.next = new ListNode(10);
		a.head1.next.next.next.next = new ListNode(1);
		a.head1.next.next.next.next.next = new ListNode(8);
		ListNode[] list = new ListNode[2];
		list[0] = head1;
		list[1] = head;

		ListNode k = mergeKLists(list);
		print(k);

	}

	static void print(ListNode prev) {
		while (prev != null) {
			System.out.print(prev.val);

			prev = prev.next;
		}
		System.out.println();
	}

}
