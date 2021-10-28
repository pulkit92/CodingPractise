package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static void main(String args[]) {
    LongestSubstringWithoutRepeatingCharacters l =
        new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(l.lengthOfLongestSubstring(" "));
  }

  public int lengthOfLongestSubstring(String s) {

    int r = 0;
    int max = Integer.MIN_VALUE;
    if (s.length() == 0) {
      return 0;
    }
    Set<Character> set = new HashSet<>();
    boolean b = false;
    while (r < s.length()) {
      char ch = s.charAt(r);
      if (!set.contains(ch)) {
        set.add(ch);
      } else {
        b = true;
        max = Math.max(max, set.size());
        set = new HashSet<>();
        set.add(ch);
      }
      r++;
    }
    if (!b) {
      max = Math.max(max, set.size());
    }
    return max;
  }
}

