package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate217 {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
			Map<Integer, Integer> set = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				if (set.containsKey(nums[i])) {
					int v = set.get(nums[i]);
					if (i - v <= k)
						return true;
					else
						set.put(nums[i], i);
				} else {
					set.put(nums[i], i);
				}
			}
			return false;

	}

	public static void main(String args[]) {
		int[] nums = { 1, 0, 1, 1 };
		System.out.println(containsNearbyDuplicate(nums, 1));
	}
}
