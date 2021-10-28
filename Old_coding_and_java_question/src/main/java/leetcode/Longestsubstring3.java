package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Longestsubstring3 {
	public static void main(String args[]) throws Exception {
		/// not done
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public static int lengthOfLongestSubstring(String s) {
		int count = 0;
		int l = s.length();
		int i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		while (i < l && j < l) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j ++));
				count = Math.max(count, j - i);
			} else
				set.remove(s.charAt(i++));
		}

		return count;
	}
}
