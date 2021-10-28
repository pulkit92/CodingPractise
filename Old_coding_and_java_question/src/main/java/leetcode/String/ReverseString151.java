package leetcode.String;

import java.util.Stack;
import java.util.stream.Collectors;

public class ReverseString151 {
  public static String reverseWords(String s) {
    int m = 0;
    Stack<String> st = new Stack();
    StringBuffer s1 = new StringBuffer();
    s = s.trim();
    s = s + " ";
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        st.push(s.substring(m, i));
        m = i + 1;

      }

    }
    while (!st.isEmpty()) {
      if (st.peek().trim().length() != 0) {
        s1.append(st.pop());
        s1.append(" ");
      } else {
        st.pop();
      }
    }
    return s1.toString().trim();
  }

  public static void main(String args[]) {
    String words = "a good   example";

    System.out.println(reverseWords(words));

  }

}
