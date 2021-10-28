package leetcode.array;

import java.util.HashMap;

public class JewelsAndStones {
	public static void main(String[] args) {
		String J = "dbca";
		String S = "beb";
		

		System.out.println(numJewelsInStones(J, S));
	}

	public static int numJewelsInStones(String J, String S) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < S.length(); i++) {
			if (map.containsKey(S.charAt(i))) {
				int value = map.get(S.charAt(i));
				value = value + 1;
				map.put(S.charAt(i), value);
			} else
				map.put(S.charAt(i), 1);
		}
		int count = 0;
		for (int i = 0; i < J.length(); i++) {
			char ch = J.charAt(i);
			if (map.containsKey(ch)) {
				count = count + map.get(ch);
			}

		}
		return count;

	}
}
