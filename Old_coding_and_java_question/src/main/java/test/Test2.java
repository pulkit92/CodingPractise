/*
package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
	public static void main(String args[]) {
		List<String> output = letterCombinations("34567");
		for (String s : output) {
			System.out.println(s);
		}
	}

	public static List<String> letterCombinations(String s) {
		String comb[] = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

		List<String> output = new ArrayList<String>();

		if (s == null || s.length() == 0)
			return output;

		List<Character> temp = new ArrayList<>();
		combinations(s, temp, output, comb);

		return output;
	}

	public static void combinations(String s, List<Character> temp, List<String> result, String[] comb) {
		if (s.length() == 0) {
			StringBuffer sb = new StringBuffer();
			for (Character c : temp) {
				sb.append(c);
			}

			result.add(sb.toString());
			return;
		}

		Integer post = Integer.valueOf(s.substring(0, 1));
		String letters = comb[post];
		for (int i = 0; i < letters.length(); i++) {
			temp.add(letters.charAt(i));
			combinations(s.substring(1), temp, result, comb);
			temp.remove(temp.size() - 1);
		}
	}
}
*/
