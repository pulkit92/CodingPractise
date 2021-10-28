package leetcode.array;

import java.util.Arrays;

public class MajorityElement169 {
	public static void main(String args[]) {
		int[] nums = { 1, 2, 3,1 };
		System.out.println(majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
		Arrays.sort(nums);
		int i = 0;
		int l = nums.length;
		int pos = 0;
		int max = 0;
		while (i < l-1) {
			int count=0;
			while(i<l-1 && nums[i]==nums[i+1])
			{
				i++;
				count++;
			}
			if(count>max)
			{
				max=count;
				pos=nums[i];
			}
			i++;
		}
		return pos;
	}
}
