package leetcode;

import java.util.Arrays;

public class LongestCommonPrefix14 {
	public static String longestCommonPrefix(String[] strs) {
		int l = strs.length;
		if(l==0)
			return "";
		int j = 0;
		boolean b = true;
		StringBuffer sb = new StringBuffer();
		Arrays.sort(strs);
		int l1 = strs[0].length();
		while (j < l1) {
			String s = strs[0].substring(0, j + 1);
			for (int i = 0; i < l; i++) {
				if (!strs[i].startsWith(s)) {
					b = false;
					break;
				}

			}
			if (b == false) {
				if (j == 0)
					sb.append("");
				else
					sb.append(s.substring(0, s.length() - 1));
				break;
			}
			j++;
		}
		if (j == l1)
			sb.append(strs[0]);
		return sb.toString();
	}

	public static void main(String[] args) {
		String arr[] = { };
		String list = longestCommonPrefix(arr);
		System.out.println(list);

	}
}
