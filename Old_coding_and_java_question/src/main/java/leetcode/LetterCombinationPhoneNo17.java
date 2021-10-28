package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetterCombinationPhoneNo17 {
	public static void main(String[] args) {

		System.out.println(letterCombinations("234"));

	}

	public static List<String> letterCombinations(String digits) {
		return letterCombinations1(digits, digits.length() - 1, new ArrayList<>());
	}

	public static List<String> letterCombinations1(String digits, int l, List<String> out) {
		String a[] = { "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		if (l == -1) {
			Collections.sort(out);
			return out;
		} else if (digits.length() - 1 == l) {
			int x = Integer.parseInt(digits.substring(l, l + 1));
			String va = a[x - 1];
			for (int i = 0; i < va.length(); i++) {
				out.add(Character.toString(va.charAt(i)));
			}
			return letterCombinations1(digits, l - 1, out);

		} else {
			int x = Integer.parseInt(digits.substring(l, l + 1));
			String va = a[x - 1];
			List<String> list = new ArrayList<>();
			for (int i = 0; i < out.size(); i++) {
				for (int j = 0; j < va.length(); j++) {
					String sna = out.get(i);
					list.add(Character.toString(va.charAt(j)) + sna);

				}
			}
			return letterCombinations1(digits, l - 1, list);

		}

	}

}
