import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CountDisjointSetsInMergeIntervals {
	public static int solution(int[] A, int[] B) {
		List<Interval> intervals = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			Interval inte = new Interval(Integer.min(A[i], B[i]), Integer.max(A[i], B[i]));
			intervals.add(inte);

		}
		return mergeIntervals(intervals);

	}

	public static void main(String[] args) {
		int B[] = { 5, 15, 44, 72, 36, 2, 69, 24 };
		int[] A = { 1, 12, 42, 70, 36, -4, 43, 15 };
		int list = solution(A, B);
		System.out.println(list);
	}

	public static int mergeIntervals(List<Interval> intervals) {
		// sort the intervals in increasing order of their starting time
		Collections.sort(intervals, (a, b) -> a.begin - b.begin);

		// create an empty stack
		Stack<Interval> stack = new Stack();

		// do for each interval
		for (Interval curr : intervals) {
			// if stack is empty or top interval in stack do not overlap
			// with current interval, push it to the stack
			if (stack.empty() || curr.begin > stack.peek().end) {
				stack.push(curr);
			}

			// if top interval of stack overlap with current interval,
			// merge two intervals by updating ending of top interval
			// to ending of current interval
			if (stack.peek().end < curr.end) {
				stack.peek().end = curr.end;
			}
		}
		return stack.size();
	}
}

class Interval {
	int begin, end;

	Interval(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}

	@Override
	public String toString() {
		return "{" + begin + "," + end + "}";
	}
};