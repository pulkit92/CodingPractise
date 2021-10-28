package leetcode;

public class NextPremutation31 {
	public static void main(String args[]) {
		int[] nums = { 1, 3, 2 };
		nextPermutation(nums);
		System.out.println(nums);
	}

	public static void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}
		int j = nums.length - 1;
		if (i >= 0) {
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);

	}

	public static void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void reverse(int nums[], int i) {
		int j = nums.length - 1;
		while (i < nums.length) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}
}
