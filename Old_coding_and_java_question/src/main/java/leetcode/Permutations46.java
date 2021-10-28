package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		List<List<Integer>> list = permute(arr);
		for (List<Integer> l : list) {
			System.out.println(l);
		}

	}

	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		return backtrack(list, new ArrayList<>(), nums);
	}

	public static List<List<Integer>> backtrack(List<List<Integer>> list2, List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			list2.add(new ArrayList<>(list));
			return list2;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					list.add(nums[i]);
					backtrack(list2, list, nums);
					list.remove(list.size() - 1);				}
				
			}

		}
		return list2;

	}
}
