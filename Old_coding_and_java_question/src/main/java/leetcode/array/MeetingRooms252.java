package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;


public class MeetingRooms252 {
	public static boolean canAttendMeetings(Interval[] intervals) {
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		List<Interval> out = new ArrayList<>();
		Stack<Interval> st = new Stack<>();
		for (Interval i : intervals) {
			if (st.isEmpty() || i.start > st.peek().end) {
				st.push(i);
			}
			if (i.end > st.peek().end) {
				st.peek().end = i.end;
			}

		}
		out.addAll(st);
		if (out.size() > 0)
			return false;
		else
			return true;

	}

	public static void main(String[] args) {
		int B[][] = { { 7, 10 }, { 2, 4 } };
		Interval[] intervals = new Interval[B.length];

		for (int i = 0; i < B.length; i++) {
			Interval interval = new Interval();
			interval.start = B[i][0];
			interval.end = B[i][1];
			intervals[i] = interval;
		}
		System.out.println(canAttendMeetings(intervals));
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}