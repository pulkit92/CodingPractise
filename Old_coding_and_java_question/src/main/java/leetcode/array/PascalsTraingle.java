package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTraingle {

	public static List<List<Integer>> generate(int numRows) {

		List<List<Integer>> list = new ArrayList<>();
		if (numRows >= 0) {
			List<Integer> l = new ArrayList<>();
			l.add(1);
			list.add(l);
		}
		if (numRows >= 1) {
			List<Integer> l = new ArrayList<>();
			l.add(1);
			l.add(1);
			list.add(l);
		}
		if (numRows > 1) {
			for (int i = 2; i < numRows; i++) {
				List<Integer> l = new ArrayList<>();
				List<Integer> l1 = list.get(list.size() - 1);
				l.add(1);
				for (int j = 0; j < l1.size() - 1; j++) {
					int sum = l1.get(j) + l1.get(j + 1);
					l.add(sum);
				}
				l.add(1);

				list.add(l);
			}
			return list;

		} else
			return list;

	}

	public static void main(String arg[]) {
		generate(5);
	}

}
