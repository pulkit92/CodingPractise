package stack;

import java.util.Stack;

public class ValidParenthesisString {
  public boolean checkValidString(String s) {
    Stack<Character> st = new Stack<>();
    Stack<Character> st1 = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '(') {
        st.push(ch);
      } else if (ch == '*') {
        st1.push(ch);
      } else {
        if (!st.empty()) {
          st.pop();
        } else if (!st1.empty()) {
          st1.pop();
        } else {
          return false;
        }



      }
    }
    while(!st.isEmpty()){
      if(!st1.isEmpty() && st1.peek() > st.peek()){
        st1.pop();
      }
      else{
        return false;
      }
      st.pop();
    }

    return true;

  }

  public static void main(String args[]) {
    ValidParenthesisString v = new ValidParenthesisString();
    System.out.println(v.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
  }
}
