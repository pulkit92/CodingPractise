package leetcode.String;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

	public static List<List<Integer>> combine(int n, int k) {
		return subsets(n, k, new ArrayList<>(), new ArrayList<>(), 1);
	}

	private static List<List<Integer>> subsets(int n, int k, List<List<Integer>> list, List<Integer> out, int start) {
		if (k == out.size()) {
			list.add(new ArrayList<>(out));
			return list;
		}

		for (int j = start; j <= n; j++) {
			if (!out.contains(j)) {
				out.add(j);
				subsets(n, k, list, out, j);
				out.remove(out.size() - 1);
			}
		}
		return list;

	}

	public static void main(String args[]) {
		int n = 4;
		int k = 2;
		List<List<Integer>> list = combine(n, k);
		for (List<Integer> l : list) {
			for (Integer i : l) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
