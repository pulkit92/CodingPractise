package stack;

import java.util.Stack;

public class ValidParentheses20 {
  public static void main(String args[]) {
    ValidParentheses20 v = new ValidParentheses20();
    System.out.println(v.isValid("]"));
  }

  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
        st.push(s.charAt(i));

      } else {
        if (!st.isEmpty()) {
          char ch = st.peek();
          if (s.charAt(i) == '}' && ch == '{') {
            st.pop();
          } else if (s.charAt(i) == ']' && ch == '[') {
            st.pop();
          } else if (s.charAt(i) == ')' && ch == '(') {
            st.pop();
          } else {
            return false;
          }

        } else {
          return false;
        }
      }
    }
    return st.isEmpty();
  }

}

