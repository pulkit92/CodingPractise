package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leet5 {
	public static void main(String args[]) {
		Leet5 l = new Leet5();
		String s = "babad";
		System.out.println(reverse(9646324351L));
		System.out.println(l.longestPalindrome(s));

	}

	public static long reverse(long x) {

		boolean b = false;
		if (x < 0) {
			b = true;
			x = x * (-1);
		}

		StringBuffer sb = new StringBuffer(String.valueOf(x));
		sb.reverse();
		long y = Long.parseLong(sb.toString());
		if (b == true) {
			y = y * (-1);
		}
		return y;

	}

	public String longestPalindrome(String s) {

		// StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		int max = 0;

		for (int i = 0; i < s.length(); i++) {

			for (int j = i + 1; j < s.length() + 1; j++) {
				StringBuffer sb = new StringBuffer();
				sb.append(s.substring(i, j));
				StringBuffer sb1 = new StringBuffer(sb);
				sb1.reverse();
				if ((sb.toString()).equals(sb1.toString())) {
					if (sb.length() > max) {
						max = sb.length();
						sb2.setLength(0);
						sb2.append(sb);
					}

				}

			}

		}
		return sb2.toString();
	}
}
