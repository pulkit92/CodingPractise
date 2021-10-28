package leetcode.array;

import java.util.Arrays;

public class ArrayPartitionI561 {
	public static void main(String args[]) {
		int nums[] = { 1,1};
		System.out.println(arrayPairSum(nums));

	}

	public static int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length / 2;
		int sum = 0;
		for (int i = 0; i < nums.length-n; i = i + n) {
			
			sum = sum + nums[i];
		}
		return sum;
	}
}
