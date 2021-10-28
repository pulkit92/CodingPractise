package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray26 {

	public static void main(String[] args) {
		int arr[] = {2,2,3,3};
		System.out.println(removeDuplicates(arr));

	}

	public static int removeDuplicates(int[] nums) {
		int j = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[j] != nums[i]) {
				j++;
				nums[j] = nums[i];
			}
		}
		return j + 1;
	}
}