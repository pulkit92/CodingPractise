package leetcode.array;

public class FindPivot {
	public static void main(String args[]) {
		int[] a = {  4,5,6,7,0,1,2 };

		System.out.println(findPivot(a, 0, a.length - 1));

	}

	static int findPivot(int a[], int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			if (end > mid && a[mid] > a[mid + 1])
				return a[mid + 1];
			if (mid > start && a[mid - 1] > a[mid])
				return a[mid];
			if (a[start] > a[mid])
				return findPivot(a, start, mid - 1);
			else
				return findPivot(a, mid + 1, end);
		}
		return -1;
	}
}
