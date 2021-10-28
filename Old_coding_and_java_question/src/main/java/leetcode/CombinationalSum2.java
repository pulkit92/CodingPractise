package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationalSum2 {

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		   List<List<Integer>> list = new LinkedList<List<Integer>>();

		backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		return list;
	}

	public static void main(String[] args) {
		int arr[] = { 10, 1, 2, 7, 6, 1, 5 };
		List<List<Integer>> list = combinationSum2(arr, 8);
		for (List<Integer> l : list) {
			System.out.println(l);
		}

	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {

		if (remain < 0)
			return; /** no solution */
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < cand.length; i++) {
				if (i > start && cand[i] == cand[i - 1])
					continue; /** skip duplicates */
				tempList.add(cand[i]);
				backtrack(list, tempList, cand, remain - cand[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}