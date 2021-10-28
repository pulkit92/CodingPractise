package leetcode.array;

public class MaximumProductSubarray152 {
	public static void main(String args[]) {
		int[] nums = {-1,5};
		System.out.println(maxProduct(nums));
	}

	public static int maxProduct(int[] nums) {
	
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int t=i;
			int prod=1;
			while(t<nums.length)
			{
				prod=prod*nums[t];
				min = Math.max(min, (prod));
				t++;
			}
		}
		return min;

	}
}
