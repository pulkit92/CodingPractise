package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass4 {
	public static void main(String args[]) throws Exception {
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine(); // Reading input frm STDINo
		StringTokenizer s = new StringTokenizer(name, ".");
		int max = 0;
		while (s.hasMoreTokens()) {
			String l = s.nextToken();
			if (l.length() > max) {
				max = l.length();
				sb.setLength(0);
				sb.append(l);
			}
		}

		System.out.println(sb.toString());

	}
}
