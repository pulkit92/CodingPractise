package leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
	public static List<List<Integer>> combinationSum3(int k, int n) {
		return combinationSum3(n, k, new ArrayList<>(), new ArrayList<>(), 1);
	}

	private static List<List<Integer>> combinationSum3(int k, int n, List<List<Integer>> list, List<Integer> out,
			int start) {
		if (k == out.size()) {
			int sum = 0;
			for (int i = 0; i < k; i++) {
				sum = sum + out.get(i);
			}
			if (sum == n) {
				list.add(new ArrayList<>(out));
				return list;
			}

		}

		for (int j = start; j <= 9; j++) {
			if (!out.contains(j) && out.size() < k) {
				out.add(j);
				combinationSum3(n, k, list, out, j);
				out.remove(out.size() - 1);
			}
		}
		return list;

	}

	public static void main(String args[]) {
		int n = 3;
		int k = 2;
		List<List<Integer>> list = combinationSum3(k, n);
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
