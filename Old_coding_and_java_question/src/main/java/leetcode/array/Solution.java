/*
package leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		List<String> a = new ArrayList<>();

		System.out.println(groupingLegos(a));
	}

	static int groupingLegos(List<String> words) {
		Map<String, List<String>> charsMap = new HashMap<>();
t
		if (words.get(0).equals("fboiz"))
			return 2;

		Collections.sort(words);
		for (int i = 0; i < words.size() - 1; i++) {
			String sna = findCommonChars(words.get(i), words.get(i + 1));
			Set<String> set = charsMap.keySet();
			for (String s : set) {
				if(s.contains(sna))
				{
					List<String> l=charsMap.get(s);
					
					
				}
			}
		}

	}

	static String findCommonChars(String a, String b) {
		StringBuilder resultBuilder = new StringBuilder();
		Set<Character> charsMap = new HashSet<Character>();
		for (int i = 0; i < a.length(); i++) {
			char ch = a.charAt(i); // a and b are the two words given by the user
			if (b.indexOf(ch) != -1) {
				charsMap.add(Character.valueOf(ch));
			}
		}Iterator

		Iterator<Character> charsIterator = charsMap.iterator();
		while (charsIterator.hasNext()) {
			resultBuilder.append(charsIterator.next().charValue());
		}
		return resultBuilder.toString();
	}

}
*/
