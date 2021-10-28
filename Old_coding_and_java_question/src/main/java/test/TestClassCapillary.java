package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClassCapillary {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a[] = br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);
		int s[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			String s1[] = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				s[i][j] = Integer.parseInt(s1[j]);
			}
		}
		int max = 0, p = 0;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			int t = m - 1;

			for (int j = 0; j < m; j++) {

				sum = (int) (sum + (Math.pow(2, t) * s[i][j]));
				t--;
			}
			if (sum > max) {
				max = sum;
				p = i;
			}

		}

		System.out.println(p + 1);

	}
}