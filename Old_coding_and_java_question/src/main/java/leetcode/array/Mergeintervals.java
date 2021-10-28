/*
package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mergeintervals {
	public List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		int i = 0;
		int l = intervals.size() - 1;
		while (i < l - 1) {
			if (intervals.get(i).end > intervals.get(i).start) {
				intervals.add(i, new Interval(intervals.get(i).start, intervals.get(i + 1).end));
				intervals.remove(intervals.get(i + 1));

			} else {
				i++;
			}
		}

		return intervals;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(intervals.get(i).start, intervals.get(i + 1).end));
		System.out.println(merge());

	}

}


*/
