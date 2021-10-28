package leetcode.array;

import java.io.*;
import java.util.*;

public class TestClass {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter wr = new PrintWriter(System.out);
		int T = Integer.parseInt(br.readLine().trim());
		for (int t_i = 0; t_i < T; t_i++) {
			String S = br.readLine();
			int Q = Integer.parseInt(br.readLine().trim());
			String[] arr_x = br.readLine().split(" ");
			int[] x = new int[Q];
			for (int i_x = 0; i_x < arr_x.length; i_x++) {
				x[i_x] = Integer.parseInt(arr_x[i_x]);
			}
			String[] arr_y = br.readLine().split(" ");
			int[] y = new int[Q];
			for (int i_y = 0; i_y < arr_y.length; i_y++) {
				y[i_y] = Integer.parseInt(arr_y[i_y]);
			}

			int out_ = solve(y, x, Q, S);
			System.out.println(out_);
			System.out.println("");
		}

		wr.close();
		br.close();
	}

	static int solve(int[] y, int[] x, int Q, String S) {
		int count = 0;
		for (int i = 0; i < Q; i++) {
			int p = x[i];
			int q = y[i];
			if (p != 0 && q != 0) {
				StringBuffer sb1 = new StringBuffer();

				StringBuffer sna = solve(p, q, 0, 0, sb1);

				boolean isFound = S.indexOf(sna.toString()) != -1 ? true : false; // true
				if (isFound)
					count++;
				else {
					StringBuffer sb = new StringBuffer(sna);
					sb.reverse();
					boolean isFound1 = S.indexOf(sb.toString()) != -1 ? true : false; // true
					if (isFound1)
						count++;
				}

			} else {
				count++;
			}
		}
		return count;
	}

	static StringBuffer solve(int p, int q, int x, int y, StringBuffer s) {

		if (x > p) {
			for (int i = p; i < x; i++) {
				s.append('L');
			}
		}
		if (x < p) {
			for (int i = x; i < p; i++) {
				s.append('R');
			}
		}
		if (y < q) {
			for (int i = y; i < q; i++) {
				s.append('U');
			}
		}
		if (y > q) {
			for (int i = q; i < y; i++) {
				s.append('D');
			}
		}

		return s;
	}
}