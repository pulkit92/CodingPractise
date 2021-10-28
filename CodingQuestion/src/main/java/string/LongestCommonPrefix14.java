package string;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonPrefix14 {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }

    List<Character> list = new ArrayList<>();
    for (int i = 0; i < strs[0].length(); i++) {
      list.add(strs[0].charAt(i));
    }

    for (int j = 1; j < strs.length; j++) {
      List<Character> s = new ArrayList<>();

      for (int i = 0; i < Math.min(strs[j].length(), list.size()); i++) {
        if (strs[j].charAt(i) == list.get(i)) {
          s.add(strs[j].charAt(i));
        } else if (strs[j].equals("")) {
          return "";
        } else {
          break;
        }
      }
      list.clear();
      list.addAll(s);
    }

    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < list.size(); i++) {
      stringBuffer.append(list.get(i));
    }
    return stringBuffer.toString();

  }


  public static void main(String args[]) {
    LongestCommonPrefix14 l = new LongestCommonPrefix14();
    String a[] = {"aca", "cba"};
    System.out.println(l.longestCommonPrefix(a));
  }
}
