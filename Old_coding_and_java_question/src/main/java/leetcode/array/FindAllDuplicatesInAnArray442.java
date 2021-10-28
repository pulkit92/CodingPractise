package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray442 {
	public static void main(String args[]) {
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };

		System.out.println(findDuplicates(a));

	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> a = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i] - 1);
			if (nums[val] >= 0) {
				nums[val] = -nums[val];
			} else
				a.add(Math.abs(nums[val]));

		}
		return a;
	}

}
