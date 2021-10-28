package leetcode.array;

public class MergeSortedArray88 {
	public static void main(String[] args) {
		int nums1[] = { 6, 7, 0, 0, 0 };
		int m = 2;
		int nums2[] = { 8, 9, 10 };
		int n = 3;
		merge(nums1, m, nums2, n);

		for (int k : nums1)
			System.out.println(k);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int y = m + n;
		while (m > 0 && n > 0) {
			if (nums2[n - 1] > nums1[m - 1]) {
				nums1[y - 1] = nums2[n - 1];
				y--;
				n--;
			} else {
				nums1[y - 1] = nums1[m - 1];
				y--;
				m--;
			}

		}
		while (n > 0) {
			nums1[n - 1] = nums2[n - 1];
			n--;
		}
	}

}
