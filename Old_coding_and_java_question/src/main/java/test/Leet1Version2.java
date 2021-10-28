package test;

import java.util.Arrays;

public class Leet1Version2 {
	public static void main(String args[]) {
		int a[] = { 3,2,4,6};
		int n = 10;
		twoSum(a, n);
		/*
		 * for (int i = 0; i < 2; i++) System.out.println(twoSum(a, n)[i]);
		 */
	}

	public static int[] twoSum(int[] nums, int target) {
		Arrays.sort(nums);
		int s = 0;
		int l = nums.length;
		int m = (l % 2 == 0) ? l / 2 : (l / 2);
		while (l > s) {
			if (nums[m] > target) {
				
				l=m;
			}
			else
			{
				s=m;
			}
		}
		return nums;
	}
}
