package test;

public class Leet4 {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double sum1 = 0, sum2 = 0, sum = 0;

		for (int i = 0; i < nums1.length; i++) {
			sum1 = sum1 + nums1[i];
		}
		for (int j = 0; j < nums2.length; j++) {
			sum2 = sum2 + nums2[j];
		}
		sum = (sum1 + sum2) / (nums1.length + nums2.length);
		return sum;

	}

	public static void main(String args[]) {
		Leet4 l = new Leet4();
		int a[] = {1,2};
		int b[] = {3,4};
		double c = l.findMedianSortedArrays(a, b);
		System.out.println(c);

	}
}
