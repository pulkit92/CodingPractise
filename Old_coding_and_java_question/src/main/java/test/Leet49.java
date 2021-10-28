package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet49 {
	public static void main(String args[]) {
		Leet49 l = new Leet49();
		String str[] = { "eat", "tea","ate", "tan", "nat", "bat" };
		System.out.println(l.groupAnagrams(str));

	}

		public List<List<String>> groupAnagrams(String[] strs) {
			List<String> a = new ArrayList<>(Arrays.asList(strs));
			List<List<String>> out = new ArrayList<>();
	
			for (int i = 0; i < a.size(); i++) {
				List<String> out1 = new ArrayList<>();
				String na = a.get(i);
				
				out1.add(na);
	
				Set<Character> set = new HashSet<>();
				for (int j = 0; j < na.length(); j++) {
					set.add(na.charAt(j));
	
				}
				for (int j = i + 1; j < a.size(); j++) {
					int count = 0;
					String s = a.get(j);
					for (int x = 0; x < s.length(); x++) {
						if (set.contains(s.charAt(x))) {
							count++;
						}
					}
	
					if (count == na.length()) {
						out1.add(s);
						a.remove(j);
						j--;
					}
				}
	
				out.add(out1);
	
			}
			return out;
	
		}
}
