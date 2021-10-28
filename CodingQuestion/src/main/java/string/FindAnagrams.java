package string;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
  public static void main(String args[]) {
    FindAnagrams findAnagrams = new FindAnagrams();
    findAnagrams.findAnagrams("abac", "ab");
  }

  public void findAnagrams(String s, String p) {
    List<Integer> list = new ArrayList<>();
    int count = 0;
    if (s.length() == 0 || p.length() == 0) {
      System.out.println("No Anagram present");
      return;
    }
    int[] charCount = new int[26];
    for (Character c : p.toCharArray()) {
      charCount[c - 'a']++;
    }

    int start = 0, end = 0, len = p.length();
    int diff = len;
    char c;
    for (end = 0; end < len; end++) {
      c = s.charAt(end);
      charCount[c - 'a']--;
      if (charCount[c - 'a'] >= 0) {
        diff--;
      }
    }
    if (diff == 0) {
      count++;
    }
    while (end < s.length()) {
      c = s.charAt(start);
      if (charCount[c - 'a'] >= 0) {
        diff++;
      }
      charCount[c - 'a']++;
      start++;
      c = s.charAt(end);
      charCount[c - 'a']--;
      if (charCount[c - 'a'] >= 0) {
        diff--;
      }
      if (diff == 0) {
        count++;
      }
      end++;
    }
    System.out.println("print count " + count);
  }
}
