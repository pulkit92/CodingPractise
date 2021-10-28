package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {
  PriorityQueue<Integer> maxHeap = null;
  PriorityQueue<Integer> minHeap = null;

  public FindMedianFromDataStream295() {
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    minHeap = new PriorityQueue<>();
  }

  public void addNum(int num) {
    minHeap.add(num);
    maxHeap.add(minHeap.poll());
    if (maxHeap.size() > minHeap.size()) {
      minHeap.add(maxHeap.poll());
    }

  }

  public double findMedian() {
    if (minHeap.size() > maxHeap.size()) {
      return minHeap.peek();
    }
    double a = (double) (maxHeap.peek() + minHeap.peek()) / 2;
    return a;
  }

  public static void main(String args[]) {
    FindMedianFromDataStream295 f = new FindMedianFromDataStream295();
    f.addNum(1);
    f.addNum(2);
    System.out.println(f.findMedian());
    f.addNum(3);
    System.out.println(f.findMedian());
    f.addNum(4);
    System.out.println(f.findMedian());
    f.addNum(5);

    System.out.println(f.findMedian());

  }
}
