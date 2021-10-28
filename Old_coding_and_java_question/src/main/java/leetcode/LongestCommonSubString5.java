package leetcode;

public class LongestCommonSubString5 {
	public static void main(String[] args) {
		String arr = "cbbd";
		String list = longestPalindrome(arr);
		System.out.println(list);

	}

	public static String longestPalindrome(String s) {
		int max = Integer.MIN_VALUE;
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < s.length(); i++) {
			sb2.append(s.charAt(i));
			sb1.append(sb2);
			if ((sb1.reverse().toString()).equals(sb2.toString())) {
				if (sb2.length() > max)
					max = sb2.length();
				sb.setLength(0);
				sb.append(sb2);
			}
			sb1.setLength(0);

		}
		return sb.toString();
	}
}
