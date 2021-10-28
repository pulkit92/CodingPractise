package leetcode;

import java.util.Stack;

public class ValidParentheses20 {
	public static void main(String args[]) throws Exception {
		/// not done
		String s = "(])";
		System.out.println(isValid(s));
	}

	public static boolean isValid(String s) {

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[') {
				st.push(ch);
			} else {
				if (st.empty())
					return false;
				char peek = st.peek();
				if (ch == '}') {
					if (peek == '{') {
						st.pop();
					}
					else
					
					{
						return false;
					}

				}
				if (ch == ')') {
					if (peek == '(') {
						st.pop();
					}
					else
						
					{
						return false;
					}

				}
				if (ch == ']') {
					if (peek == '[') {
						st.pop();
					
					}
					else
						
					{
						return false;
					}

				}
			}

		}
		Math.pow(2, 3);
		if (st.empty())
			return true;

		return false;

	}
}