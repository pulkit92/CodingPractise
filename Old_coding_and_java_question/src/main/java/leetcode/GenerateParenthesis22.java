package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
	public static void main(String args[]) {
		System.out.println(generateParenthesis(2));
	}

	public static List<String> generateParenthesis(int n) {
		return backtrace(new ArrayList<>(), "", 0, 0, n);
	}

	public static List<String> backtrace(List<String> out, String na, int open, int close, int max) {
		if (na.length() == max * 2) {
			out.add(na);
			return out;
		}
		if (max > open) {
			backtrace(out, na + "(", open+1, close, max);
		}
		if (open > close)
			backtrace(out, na + ")", open, close+1, max);
		return out;
	}
}
