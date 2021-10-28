package leetcode;

public class SearchInsertPosition35 {
	public static int searchInsert(int[] nums, int target) {
		return binarySearch(nums, target, 0, nums.length - 1);
	}

	static int binarySearch(int nums[], int target, int low, int high) {
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if ((target > nums[mid]) && ((mid>=high)|| (nums[mid + 1] > target))) {
			return mid + 1;
		}
		if ((target < nums[mid]) && ((low>=mid)||(nums[mid - 1] < target))) {
			return mid;
		}
		if (target > nums[mid]) {
			return binarySearch(nums, target, mid + 1, high);
		}
		return binarySearch(nums, target, low, mid - 1);
	}

	public static void main(String args[]) {
		int nums[] = { 1, 3, 5, 6 };
		int target = 4;
		System.out.println(searchInsert(nums, target));
	}
}
