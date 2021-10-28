package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class WordBreak139 {
	public static void main(String[] args) {
		String s = "leetcode";
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");

		System.out.println(wordBreak(s, wordDict));
	}

	public static boolean wordBreak(String s, List<String> wordDict) {
		StringBuffer sb = new StringBuffer();
		return check(s, wordDict, 0, s.length(), sb);
	}

	public static boolean check(String s, List<String> wordDict, int i, int j, StringBuffer sb) {
		if (s.length() == 0)
			return true;
		if (i == j-1)
			return false;

		for (int k = i; k < j; k++) {
			String s1 = s.substring(0, k +1);
			if (wordDict.contains(s1)) {
				sb.append(s1);
				String n=s.substring(k+1, j );
				check(n, wordDict, 0, n.length(), sb);
			} else {
				//sb.append(s1);
				/*if (wordDict.contains(sb.toString())) {
					String n=s.substring(k, j );
					sb.setLength(0);
					check(n, wordDict, 0,n.length(), sb);
				}*/
			}
		}
		return false;

	}
}
