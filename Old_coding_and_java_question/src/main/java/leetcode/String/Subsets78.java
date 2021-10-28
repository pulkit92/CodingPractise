package leetcode.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets78 {
	public static void main(String args[]) {
		int nums[] = { 1, 2, 2 };
		List<List<Integer>> list = subsets(nums);
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
			Arrays.sort(nums);
			return subsets(nums, new ArrayList<>(), new HashSet<>(), 0);

	}

	private static List<List<Integer>> subsets(int[] nums, List<List<Integer>> list, Set<Integer> out, int start) {

		if (!list.contains(out))
			list.add(new ArrayList<>(out));
		for (int i = start; i < nums.length; i++) {
			out.add(nums[i]);
			subsets(nums, list, out, i + 1);
			out.remove(out.size() - 1);
		}

		return list;

	}

}
