package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> lo;
	PriorityQueue<Integer> hi;

	/** initialize your data structure here. */
	public MedianFinder() {
		lo = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 > o2)
					return 1;
				else
					return -1;
			}
		});
		hi = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if (o1 < o2)
					return 1;
				else
					return -1;
			}
		});

	}

	public void addNum(int num) {
		lo.add(num);
		hi.add(num);

	}

	public double findMedian() {
		return 0;

	}

	public static void main(String args[]) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);

	}
}
