package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class TestClass {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a[] = new int[t];
		for (int u = 0; u < t; u++) {
			long m = Long.parseLong(br.readLine());
			List<Long> b = new ArrayList<>();
			long sum = 0;

			for (int j = 1; j <= m; j++) {
				sum = sum + getBeauty(j);
				b.add(sum);
			}
			long x = findClosest(b, m);

			System.out.println(binarySearch(b, 0, b.size() - 1, x) + 1);
		}

	}

	static int binarySearch(List<Long> b, int l, int r, long x) {
		if (r >= l) {
			int mid = l + (r - l) / 2;

			// If the element is present at the
			// middle itself
			if (b.get(mid) == x)
				return mid;

			// If element is smaller than mid, then
			// it can only be present in left subarray
			if (b.get(mid) > x)
				return binarySearch(b, l, mid - 1, x);

			// Else the element can only be present
			// in right subarray
			return binarySearch(b, mid + 1, r, x);
		}
		return -1;
	}

	public static long findClosest(List<Long> b, long m) {
		int n = b.size();

		// Corner cases
		if (m <= b.get(0))
			return b.get(0);
		if (m >= b.get(b.size() - 1))
			return b.get(b.size() - 1);

		// Doing binary search
		int i = 0, j = n, mid = 0;
		while (i < j) {
			mid = (i + j) / 2;

			if (b.get(mid) == m)
				return b.get(mid);

			/*
			 * If target is less than array element, then search in left
			 */
			if (m < b.get(mid)) {

				// If target is greater than previous
				// to mid, return closest of two
				if (mid > 0 && m > b.get(mid - 1))
					return getClosest(b.get(mid - 1), b.get(mid), m);

				/* Repeat for left half */
				j = mid;
			}

			// If target is greater than mid
			else {
				if (mid < n - 1 && m < b.get(mid + 1))
					return getClosest(b.get(mid), b.get(mid + 1), m);
				i = mid + 1; // update i
			}
		}

		// Only single element left after search
		return b.get(mid);
	}

	public static long getClosest(long b, long b2, long m) {
		if (m - b >= b2 - m)
			return b2;
		else
			return b;
	}

	static int getBeauty(long number) {
		int beauty = 0;
		while (number > 0) {
			beauty += (number & 1);
			number = number / 2;

		}
		return beauty;
	}

}
