package string;

import java.util.Stack;

public class BackSpaceStringCompare {
  public boolean backspaceCompare(String S, String T) {
    Stack<Character> st = new Stack<>();
    Stack<Character> st1 = new Stack<>();
    for (int i = 0; i < S.length(); i++) {
      if (S.charAt(i) == '#' && !st.empty()) {
        st.pop();
      } else if (S.charAt(i) != '#') {
        st.push(S.charAt(i));
      }
    }

    for (int i = 0; i < T.length(); i++) {
      if (T.charAt(i) == '#' && !st1.empty()) {
        st1.pop();
      } else if (T.charAt(i) != '#') {
        st1.push(T.charAt(i));
      }
    }
    if (st.toString().equals(st1.toString())) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    BackSpaceStringCompare backSpaceStringCompare = new BackSpaceStringCompare();
    System.out.println(backSpaceStringCompare.backspaceCompare("y#fo##f", "y#f#o##f"));
  }
}

