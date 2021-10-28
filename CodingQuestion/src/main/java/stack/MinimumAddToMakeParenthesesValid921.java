package stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid921 {
  public int minAddToMakeValid(String S) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      char ch = S.charAt(i);
      if (!st.isEmpty()) {
        char stch = st.peek();
        if (stch == '(' && ch == ')') {
          st.pop();
        } else {
          st.push(ch);
        }

      } else {
        st.push(ch);
      }
    }
    return st.size();
  }

  public static void main(String args[]) {
    MinimumAddToMakeParenthesesValid921 m = new MinimumAddToMakeParenthesesValid921();
    System.out.println(m.minAddToMakeValid("((("));
  }
}
