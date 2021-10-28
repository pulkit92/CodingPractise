package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestClass2 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // Reading input from STDIN
		Map<Integer, List<String>> map = new LinkedHashMap<>();
		for (int i = 0; i < n; i++) {
			List<String> list = new ArrayList<>();
			int x = Integer.parseInt(br.readLine()); // Reading input from STDIN
			for (int j = 0; j < x; j++) {
				String na = br.readLine();
				list.add(na);
			}
			map.put(i, list);
		}
		Set<Integer> s = map.keySet();
		for (int k : s) {
			List<String> s1 = map.get(k);
			Collections.sort(s1, new Comparator<String>() {

				@Override
				public int compare(String s1, String s2) {
					String s3[] = s1.split(" ");
					String s4[] = s2.split(" ");

					int a = Integer.parseInt(s3[0]);
					int b = Integer.parseInt(s4[0]);
					return (a >= b) ? 1 : -1;

				}
			});
			System.out.println(overlap(s1));

		}

	}

	static boolean overlap(List<String> s1) {
		for (int i = 1; i < s1.size(); i++) {
			String s3[] = s1.get(i).split(" ");
			String s4[] = s1.get(i - 1).split(" ");
			if (Integer.parseInt(s3[0]) <= Integer.parseInt(s4[1])) {
				return true;
			}
		}
		return false;

	}

}
