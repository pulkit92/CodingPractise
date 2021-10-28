package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
    int max = 1;

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    priorityQueue.add(intervals[0][1]);
    for (int i = 1; i < intervals.length; i++) {
      while (!priorityQueue.isEmpty() && priorityQueue.peek() <= intervals[i][0]) {
        priorityQueue.poll();
      }
      priorityQueue.add(intervals[i][1]);
      max = Math.max(max, priorityQueue.size());
    }
    return max;
  }


  public static void main(String args[]) {
    int[][] room = {{100, 300}, {145, 215}, {200, 230}, {215, 300}, {215, 400}, {500, 600}, {600, 700}};
    MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
    System.out.println(meetingRoomsII.minMeetingRooms(room));
  }
}
