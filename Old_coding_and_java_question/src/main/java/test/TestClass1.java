package test;/*package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass1 {
	public static void main(String args[]) throws Exception {

		// BufferedReader
		Map<Integer, String> map = new LinkedHashMap<>();
		map.f
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // Reading input from STDIN
		for (int i = 0; i < n; i++) {
			String na = br.readLine();
			int x = Integer.parseInt(br.readLine());
			map.put(x, na);
		}
		Set<Integer> s = map.keySet();
		for (int k : s) {
			int c = 1;
			StringBuffer sna = new StringBuffer(map.get(k));
			for (int m = 0; m < sna.length(); m++) {
				while (c <= k) {
					char ch = sna.charAt(m);
					if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
						sna.replace(m, m + 1, String.valueOf((char) (ch + 1)));
						c++;
					}
					break;

				}

			}
			System.out.println(sna);

		}

	}
}
*/