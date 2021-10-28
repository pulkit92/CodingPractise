package string;

import java.util.HashSet;
import java.util.Set;

class LIS {
  /* lis() returns the length of the longest
     increasing subsequence in arr[] of size n */
  public static boolean repeating(String s, String t) {

    if (s.length() % t.length() != 0) {
      return false;
    }

    Set<Character> set1 = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      set1.add(s.charAt(i));
    }
    for (int i = 0; i < t.length(); i++) {
      if (!set1.contains(t.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String args[]) {
    int arr[] = {50, 3, 10, 7, 40, 80};
    int n = arr.length;
    System.out.println(findSmallestDivisor("ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo", "ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"));
  }

  public static int findSmallestDivisor(String s, String t) {
    // Write your code here

    if (repeating(s, t)) {
      String s1 = repe(s);
      String t1 = repe(s);

      if (s1.equals(t1)) {
        Set<Character> set1 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
          set1.add(s1.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
          if (!set1.contains(t.charAt(i))) {
            return t.length();
          }
          return s1.length();
        }
      } else {
        return t.length();
      }

    }
    return -1;

  }

  public static String repe(String str) {
    String lrs = "";
    int n = str.length();
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        //Checks for the largest common factors in every substring
        String x = lcp(str.substring(i, n), str.substring(j, n));
        //If the current prefix is greater than previous one
        //then it takes the current one as longest repeating sequence
        if (x.length() > lrs.length()) {
          lrs = x;
        }
      }
    }
    return lrs;
  }

  public static String lcp(String s, String t) {
    int n = Math.min(s.length(), t.length());
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) != t.charAt(i)) {
        return s.substring(0, i);
      }
    }
    return s.substring(0, n);
  }

}