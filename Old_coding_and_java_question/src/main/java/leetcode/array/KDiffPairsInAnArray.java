package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;

public class KDiffPairsInAnArray {
	public static int findPairs(int[] nums, int k) {
		int count = 0;
		Arrays.sort(nums);
		HashMap<Integer, Integer> map = new HashMap<>();
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int diff = k + nums[i];
			if (map.containsKey(nums[i])) {
				map1.put(diff, nums[i]);
				map.put(diff, nums[i]);

			} else {
				map.put(diff, nums[i]);
			}
		}
		return map1.size();
	}

	public static void main(String[] args) {
		int nums1[] = { 1, 3, 1, 5, 4 };

		System.out.println(findPairs(nums1, 0));
	}

}
