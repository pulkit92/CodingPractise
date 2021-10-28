package leetcode;

public class SearchRoatedArray33 {
	public static void main(String[] args) {
		int arr[] = { 3,1 };
		System.out.println(search(arr, 1));

	}

	public static int search(int[] nums, int target) {
		int pivot = findPivot(nums, 0, nums.length - 1);
		if (pivot == -1) {
			return binarysearch(nums, 0, nums.length - 1, target);

		}
		if (nums[pivot] == target)
			return pivot;
		if (nums[0] > target) {
			return binarysearch(nums, pivot + 1, nums.length - 1, target);
		}
		return binarysearch(nums, 0, pivot - 1, target);

	}

	public static int binarysearch(int a[], int start, int end, int target) {
		while (end >= start) {
			int mid = (start + end) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (target > a[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}

		}
		return -1;
	}

	public static int findPivot(int a[], int start, int end) {
		if (start > end)
			return -1;

		if (start == end)
			return start;

		int mid = (start + end) / 2;
		if (end > mid && a[mid] > a[mid + 1]) {
			return mid;
		}
		if (mid > start && a[mid - 1] > a[mid]) {
			return mid-1;
		}
		if (a[mid] > a[start])
			return findPivot(a, mid + 1, end);

		return findPivot(a, start, mid - 1);

	}
}
