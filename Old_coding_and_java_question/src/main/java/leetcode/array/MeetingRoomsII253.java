package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII253 {
  public static int minMeetingRooms(Interval[] intervals) {
    if (intervals.length <= 0) {
      return 0;
    }
    PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {

      @Override
      public int compare(Interval a, Interval b) {

        return a.end - b.end;
      }
    });

    Arrays.sort(intervals, new Comparator<Interval>() {

      @Override
      public int compare(Interval a, Interval b) {
        return a.start - b.start;
      }
    });
    for (Interval i : intervals) {
      if (!queue.isEmpty()) {
        if (queue.peek().end < i.start) {
          queue.poll();
        }
      }
      queue.add(i);
    }
    return queue.size();
  }

  public static void main(String[] args) {
    int B[][] = {{7, 10}, {2, 4}};
    Interval[] intervals = new Interval[B.length];

    for (int i = 0; i < B.length; i++) {
      Interval interval = new Interval();
      interval.start = B[i][0];
      interval.end = B[i][1];
      intervals[i] = interval;
    }
    System.out.println(minMeetingRooms(intervals));
  }
}
