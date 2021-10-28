package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = 0; i < stones.length; i++) {
      queue.add(stones[i]);
    }
    while (queue.size() > 1) {
      int x = queue.poll();
      int y = queue.size() > 0 ? queue.poll() : 0;
      queue.add(x - y);
    }
    if (queue.size() > 0) {
      return queue.poll();
    } else {
      return 0;
    }


  }

  public static void main(String args[]) {
    int a[] = {2, 7, 4, 1, 8, 1};
    LastStoneWeight l = new LastStoneWeight();
    System.out.println(l.lastStoneWeight(a));
  }
}
