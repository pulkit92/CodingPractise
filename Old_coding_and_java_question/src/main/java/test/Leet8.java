package test;

public class Leet8 {
	public static void main(String args[]) {
		Leet8 l = new Leet8();
		String na = "4193 with words";
		System.out.println(l.myAtoi(na));
		
	}

	public int myAtoi(String str) {
		String na = str.trim();
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		StringBuffer sb = new StringBuffer();
		if (na.length() <= 0) {
			return 0;
		}

		char ch1 = na.charAt(0);
		if (ch1 == '-' || ch1 >= 48 && ch1 <= 57) {
		} else {
			return 0;
		}
		for (int i = 0; i < na.length(); i++) {
			char ch = na.charAt(i);
			int as = (int) ch;
			if (ch == '-' || as >= 48 && as <= 57) {
				sb.append(ch);
			} 	else if(ch=='.') {
				break;
			}

		}
		try {
			int x = Integer.parseInt(sb.toString());
			return x;

		} catch (Exception ex) {

			char ch = sb.charAt(0);
			if (ch == '-') {
				return min;
			} else if (ch >= 48 && ch <= 57) {
				return max;
			}

			return 0;
		}
	}
}
