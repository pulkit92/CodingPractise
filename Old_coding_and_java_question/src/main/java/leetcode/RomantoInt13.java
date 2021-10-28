package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RomantoInt13 {
	public static void main(String args[]) throws Exception {
		/// not done
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "MDLXX";
		System.out.println(romanToInt(s));
	}

	public static int romanToInt(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (map.containsKey(ch)) {
				boolean b = false;
				if (ch == 'I' && (i != s.length() - 1)) {
					char ch1 = s.charAt(i + 1);
					if (ch1 == 'V') {
						b = true;
						sum = sum + 4;
						i++;
					}
					if (ch1 == 'X') {
						{
							b = true;
							sum = sum + 9;
							i++;
						}

					}
				}
				if ((ch == 'X') && (i  != s.length() - 1)) {
					char ch1 = s.charAt(i + 1);
					if (ch1 == 'L') {
						b = true;
						sum = sum + 40;
						i++;
					}
					if (ch1 == 'C') {
						{
							b = true;
							sum = sum + 90;
							i++;
						}

					}
				}
				if ((ch == 'C') && (i  != s.length() - 1)) {
					char ch1 = s.charAt(i + 1);
					if (ch1 == 'D') {
						b = true;
						sum = sum + 400;
						i++;
					}
					if (ch1 == 'M') {
						b = true;
						sum = sum + 900;
						i++;

					}
				}
				if (!b) {
					sum = sum + map.get(ch);
				}
			}
		}
		return sum;

	}
}
