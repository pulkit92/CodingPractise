package leetcode.String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissingWords {
	public static List<String> missingWords(String s, String t) {
		List<String> list = new ArrayList<>();
		String a[] = s.split(" ");
		String a1[] = t.split(" ");
		Set<String> set = new HashSet<>();
		for (String s1 : a) {
			set.add(s1);
		}
		for (String s1 : a1) {
			if (set.contains(s1)) {
				set.remove(s1);
			}
		}
		 list.addAll(set);
		return list;

		// Write your code here

	}

	public static void main(String args[]) {
		String words = "I am using HackerRank to improve programming";

		String s = "am HackerRank to improve";
		System.out.println(missingWords(words, s));

	}

}
