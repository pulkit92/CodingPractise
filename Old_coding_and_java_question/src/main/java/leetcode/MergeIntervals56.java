package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MergeIntervals56 {
	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		int i = 0;
		int l = intervals.size() - 1;
		while (i < l ) {
			if (intervals.get(i).end > intervals.get(i + 1).start) {
				Interval y = intervals.get(i);
				Interval x = intervals.get(i + 1);
				intervals.remove(x);
				intervals.remove(y);

				intervals.add(i, new Interval(y.start, x.end));
				l = intervals.size() - 1;
			} else {
				i++;
			}
		}

		return intervals;
		
	}

	public static List<Interval> makeList(int[] A, int[] B) {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			Interval inte = new Interval(Integer.min(A[i], B[i]), Integer.max(A[i], B[i]));
			intervals.add(inte);

		}
		return merge(intervals);

	}

	public static void main(String[] args) {
		int B[] = { 1, 0, 3 };
		int[] A = { 4, 2, 5 };
		List<Interval> list = makeList(A, B);
		for (Interval i : list) {
			System.out.print(i.start + "  " + i.end);
			System.out.println();
		}
	}
}

class Interval {
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	}

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