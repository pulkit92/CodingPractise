package leetcode.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		List<Character> list = new ArrayList<>();
		List<Character> list1 = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
			list1.add(t.charAt(i));
		}
		Collections.sort(list);
		Collections.sort(list1);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != list1.get(i))
				return false;
		}
		return true;

	}

	public static void main(String args[]) {
		String s = "anagram";
		String t = "nagaram";
		System.out.println(isAnagram(s, t));
	}
}
