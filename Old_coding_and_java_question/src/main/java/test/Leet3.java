package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet3 {
	public static void main(String args[]) throws Exception {
///not done
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		List<String> list = new ArrayList<>();
		// StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length() + 1; j++) {
				StringBuffer sb = new StringBuffer();
				sb.append(s.substring(i, j));
				list.add(sb.toString());
			}

		}
		// Collections.sort(s);
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {

				Integer a = s1.length();
				Integer b = s2.length();
				return b.compareTo(a);

			}
		});
		StringBuffer sb1 = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			String s1 = list.get(i);
			boolean c = true;
			boolean b[] = new boolean[128];

			for (int j = 0; j < s1.length(); j++) {
				char ch = s1.charAt(j);
				if (b[ch] == true) {
					c = false;
					break;
				}
				b[ch] = true;
			}
			if (c == true) {
				sb1.append(s1);
				break;

			}

		}

		System.out.println(sb1.length());

	}
}