package leetcode;

import java.util.Arrays;

public class sum3closest {
	public static void main(String[] args) {
		int arr[] = { -1, 2, 1, -4 };
		int tar = 1;
		int list = threeSumClosest(arr, tar);
		System.out.println(list);

	}

	private static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int l = nums.length;
		int maxsum = 0;
		int maxdiff = Integer.MAX_VALUE;
		for (int i = 0; i < l - 2; i++) {
			int a = i + 1;
			int b = l - 1;
			while (a < b) {
				int sum = nums[i] + nums[a] + nums[b];
				int diff = Math.abs(sum - target);
				if (maxdiff > diff) {
					maxsum = sum;
					maxdiff = diff;
				}
				if (sum > target) {
					b--;

				} else {
					a++;
				}
			}

		}

		return maxsum;
	}

}
