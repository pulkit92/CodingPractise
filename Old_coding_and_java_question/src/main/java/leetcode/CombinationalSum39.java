package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum39 {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return combinationSum2(candidates, target, new ArrayList<>(), new ArrayList<>(), 0, 0);

	}

	public static List<List<Integer>> combinationSum2(int[] candidates, int target, List<List<Integer>> out,
			List<Integer> out1, int sum, int i) {
		if (sum == target) {
			out.add(new ArrayList<>(out1));
			return out;
		}
		while (i < candidates.length && target > sum) {
			sum = sum + candidates[i];
			out1.add(candidates[i]);
			combinationSum2(candidates, target, out, out1, sum, i);
			out1.remove(out1.size() - 1);
			sum = sum - candidates[i];
			i++;


		}
		return out;

	}

	public static void main(String[] args) {
		int arr[] = { 10,1,2,7,6,1,5 };
		List<List<Integer>> list = combinationSum(arr, 8);
		for (List<Integer> l : list) {
			System.out.println(l);
		}

	}
}
