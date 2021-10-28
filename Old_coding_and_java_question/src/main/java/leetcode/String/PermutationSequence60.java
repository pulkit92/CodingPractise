package leetcode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PermutationSequence60 {
	static int i = 1;

	public static String getPermutation(int n, int k) {
		return getPermutation(n, k, "", new LinkedHashSet<Integer>());
	}

	private static String getPermutation(int n, int k, String sna, Set<Integer> list) {
		if (n == list.size()) {
			StringBuffer sb = new StringBuffer();
			for (int m : list) {
				sb.append(String.valueOf(m));
			}

			if (i == k) {
				sna = new String(sb.toString());
			}
			i++;
		}

		for (int j = 1; j <= n; j++) {
			if (!list.contains(j) && list.size() < n) {
				list.add(j);
				sna = getPermutation(n, k, sna, list);
				if(sna.length()==3)
					return sna;
				list.remove(list.size() - 1);
			}
		}
		return sna;

	}

	public static void main(String args[]) {
		int n = 3;
		int k = 3;
		String list = getPermutation(n, k);
		System.out.println(list);
	}
}
