/*
package leetcode.dp;

import java.util.Arrays;

public class SubarraySumEqualsK {

	public static int subarraySum(int[] nums, int k) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++)
			count = count + subarraySum(nums, k, i, 0);

		return count;
	}

	public static int subarraySum(int[] nums, int k, int start, int sum) {
		if (sum == k && s)
			return 1;
		if (sum < k && start < nums.length) {
			sum = sum + nums[start];
			return subarraySum(nums, k, start + 1, sum);
		}

		return 0;
	}

	public static void main(String[] args) {
		int arr[] = { 1 };
		int list = subarraySum(arr, 0);
		System.out.println(list);

	}
}
*/
