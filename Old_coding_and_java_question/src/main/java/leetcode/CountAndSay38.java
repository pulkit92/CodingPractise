package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CountAndSay38 {
	static int lastkey = 5;
	static Map<Integer, String> map = new HashMap<>();
	static {

		map.put(1, "1");
		map.put(2, "11");
		map.put(3, "21");
		map.put(4, "1211");
		map.put(5, "111221");

	}

	public static String countAndSay(int n) {
		if (n < 0)
			return null;

		int diff = n - lastkey;
		if (map.containsKey(n))
			return map.get(n);

		for (int i = 0; i < diff; i++) {
			StringBuffer out = new StringBuffer();
			StringBuffer s = new StringBuffer(map.get(lastkey));
			int count = 1;

			for (int j = 0; j < s.length(); j++) {
				if (j + 1 < s.length() && s.charAt(j) == s.charAt(j + 1)) {
					count++;
				} else {
					out.append(String.valueOf(count));
					out.append(String.valueOf(s.charAt(j)));
					count = 1;
				}
			}
			map.put(++lastkey, out.toString());
		}
		return map.get(lastkey);
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(9));

	}
}
