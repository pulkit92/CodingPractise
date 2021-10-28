package leetcode.array;

public class MaximumSubarray53 {
	public static void main(String args[]) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}

	static int max = Integer.MIN_VALUE;

	public static int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length);

	}

	public static int maxSubArray(int[] nums, int l, int r) {
		if (l - r == 1)
			return nums[l];
		int sum = 0;
		int mid = (l + r) / 2;
		int u = maxSubArray(nums, l, mid);
		sum = sum + u;
		if (u > sum) {
			sum = u;
		}
		int v = maxSubArray(nums, mid + 1, r);
		sum = sum + v;
		if (v > sum) {
			sum = u;
		}
		if (sum > max)
			max = sum;

		return sum;

	}
}
