package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingNumberGFG {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		MissingNumberGFG m = new MissingNumberGFG();
		for (int i = 0; i < t; i++) {
			int l = Integer.parseInt(br.readLine());
			String a[] = br.readLine().split(" ");
			int mn[] = new int[a.length];
			for (int j = 0; j < a.length; j++) {
				mn[j] = Integer.parseInt(a[j]);

			}
			Arrays.sort(mn);
			System.out.println(m.getMissingNumber(mn, l));

		}

	}

	public int getMissingNumber(int a[], int l) {
		int p = 1;
		for (int i = 0; i < a.length; i++) {
			if (p == a[i]) {
				p++;
				continue;
			} else {
				break;
			}
		}
		return p;
	}

}
