package slidingwindow;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters395 {
  public static void main(String args[]) {
    LongestSubstringWithAtLeastKRepeatingCharacters395 longestSubstringWithAtLeastKRepeatingCharacters395 =
        new LongestSubstringWithAtLeastKRepeatingCharacters395();
    System.out.println(longestSubstringWithAtLeastKRepeatingCharacters395.longestSubstring("aaabbccccaaaaaa", 3));
  }

  public int longestSubstring(String s, int k) {
    if (s.length() == 0 || k == 0) {
      return 0;
    }
    int maxLen = 9;
    int maxUnique = getMaxUniqueLetters(s);
    for (int curUnique = 1; curUnique <= maxUnique; curUnique++) {
      int unique = 0;
      int maxK = 0;
      int r = 0;
      int l = 0;
      int count[] = new int[26];
      int currentK = 0;
      while (r < s.length()) {
        if (curUnique <= unique) {
          char ch = s.charAt(r);
          int idx = ch - 'A';
          if (count[idx] == 0) {
            unique++;
          }
          count[idx]++;
          if (count[idx] == k) {
            currentK++;
          }
          r++;
        } else {
          char ch = s.charAt(l);
          int idx = ch - 'A';
          if (count[idx] == k) {
            currentK--;
          }
          count[idx]--;
          if (count[idx] == 0) {
            unique--;
          }

          l++;
        }

        if (curUnique == unique && currentK == k) {
          maxLen = Math.max(maxLen, r - l + 1);
        }
      }
    }
    return maxLen;

  }

  // get the maximum number of unique letters in the string s
  int getMaxUniqueLetters(String s) {
    boolean map[] = new boolean[26];
    int maxUnique = 0;
    for (int i = 0; i < s.length(); i++) {
      if (!map[s.charAt(i) - 'a']) {
        maxUnique++;
        map[s.charAt(i) - 'a'] = true;
      }
    }
    return maxUnique;
  }
}
