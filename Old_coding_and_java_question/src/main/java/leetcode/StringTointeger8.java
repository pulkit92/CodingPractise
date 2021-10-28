package leetcode;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StringTointeger8 {
	public static void main(String args[]) throws Exception {
		/// not done
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "-91283472332";
		System.out.println(myAtoi(s));
	}

	public static int myAtoi(String str) {
		StringBuffer sb = new StringBuffer();
		str = str.trim();
		boolean b = false;
		boolean c;
		if(str.isEmpty())
			return 0;
		char ch1 = str.charAt(0);
		if (ch1 == '-' && str.length() > 1) {
			b = true;
			ch1 = str.charAt(1);

		}
		if (!Character.isDigit(ch1)) {
			return 0;

		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch >= 48 && ch <= 57) {
				sb.append(ch);
			}
		}
		
		 if (Integer.parseInt(sb.toString()) * -1 > Integer.MAX_VALUE) {
	          return Integer.MAX_VALUE;
	        }
	        if (Integer.parseInt(sb.toString()) * -1 < Integer.MIN_VALUE) {
	          return Integer.MIN_VALUE;
	        }
		
		if (sb.length() == 0) {
			sb.append(0);
		}
		if (b == true) {
			return Integer.parseInt(sb.toString()) * -1;

		}
		return Integer.parseInt(sb.toString());
	}
}
