package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class TestClass {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		Map<Integer, String> map = new LinkedHashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // Reading input from STDIN
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());

			String na = br.readLine();
			map.put(x, na);
		}
		Set<Integer> s = map.keySet();
		for (int k : s) {
			if (k % 2 == 0) {
				if (k % 3 != 0) {
					System.out.println(-1);
				} else {
					int m = (k / 3);
					Set<String> set = new HashSet<>();
					StringBuffer sna = new StringBuffer(map.get(k).replaceAll("\\s+", ""));
					for (int i = 0; i < sna.length(); i=i+m) {
						StringBuffer a = new StringBuffer();
						a.append(sna.substring(i, i + 2));
						set.add(a.toString());

					}
					if (set.size() == 1) {
						for (String m1 : set) {
							int decimal = Integer.parseInt(m1, 2);
							System.out.println(decimal);
						}
					} else {
						System.out.println(-1);
					}

				}
			}
			else
				System.out.println(-1);
		}
	}

}
