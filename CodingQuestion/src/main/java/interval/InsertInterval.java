package interval;

import java.util.Stack;

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals == null && intervals.length == 0) {
      return new int[0][0];
    }
    int newIntervalStartTime = newInterval[0];
    int endIntervalStartTime = newInterval[1];

    Stack<Interval> stack = new Stack<>();
    for (int a[] : intervals) {
      if (!stack.isEmpty()) {
         if (stack.peek().endTime > newIntervalStartTime) {
          stack.peek().endTime = endIntervalStartTime;
        }
       else if (stack.peek().endTime < a[0]) {
          stack.add(new Interval(a[0], a[1]));
        }  else {
          stack.add(new Interval(a[0], a[1]));
        }
      } else {
        stack.add(new Interval(a[0], a[1]));
      }


    }
    return null;
  }


  public static void main(String args[]) {
    int a[][] = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    int x[] = {4, 8};
    InsertInterval insertInterval = new InsertInterval();
    System.out.println(insertInterval.insert(a, x));
  }
}


class Interval {
  int startTime;
  int endTime;

  public Interval(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }
}

/*
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */