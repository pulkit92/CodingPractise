package stack;

import java.util.Stack;

public class ValidParentheses20V2 {
  public boolean isValid(String s) {
    Stack<Character> stack = new Stack();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
        stack.push(s.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        char ch = stack.pop();
        if ((s.charAt(i) == ')' && ch == '(') || (s.charAt(i) == '}' && ch == '{') || (s.charAt(i) == ']'
            && ch == '[')) {

        } else {
          return false;
        }
      }

    }
    if (stack.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    ValidParentheses20V2 v = new ValidParentheses20V2();
    System.out.println(v.isValid("(([)]"));
  }

}
