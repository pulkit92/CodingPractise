package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 > o2)
					return 1;
				else
					return -1;
			}
		});
		for (int i : nums) {
			queue.add(i);
			if(queue.size()>k)
				queue.poll();
		}
		
		return queue.peek();

	}

	public static void main(String args[]) {
		int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		System.out.println(findKthLargest(nums, 2));
	}
}
