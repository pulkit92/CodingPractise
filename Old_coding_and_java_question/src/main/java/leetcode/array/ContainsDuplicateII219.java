package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII219 {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.contains(nums[i])) {
				set.add(nums[i]);
			} else {
				return false;
			}
		}
		return true;

	}

	public static void main(String args[]) {
		int[] nums = { 1, 2, 3 };
		System.out.println(containsDuplicate(nums));
	}
}
