package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindFirstAndLastPositionOfElementInSortedArray {
	public static void searchRange(int[] nums, int target) {

		List<Integer> list = new ArrayList<>();
		int a[] = { -1, -1 };
		bianarySearch(a, nums, target, 0, nums.length - 1);
		// int [] a=list.toArray();
		// return {1,11};
		System.out.println(a[0] + "  " + a[1]);

	}

	private static int[] bianarySearch(int list[], int[] nums, int target, int i, int j) {

		while (i <= j) {
			int mid = (i + j) / 2;
			if (nums[mid] == target) {
				int k;
				for (k = mid; k < nums.length; k++) {
					if (nums[k] != target) {
						break;
					}
				}
				list[1] = k - 1;
				for (k = mid - 1; k > 0; k--) {
					if (nums[k] != target) {
						break;
					}
				}
				list[0] = k + 1;
				return list;
			} else if (nums[mid] > target) {

				j = mid - 1;

			} else {
				i = mid + 1;
			}

		}
		return list;
	}

	public static void main(String args[]) {
		int a[] = { 1,1,2};
		int target = 1;
		searchRange(a, target);
	}
}
