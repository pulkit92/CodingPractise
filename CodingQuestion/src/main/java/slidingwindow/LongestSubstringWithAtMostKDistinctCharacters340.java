package slidingwindow;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters340 {
  public static void main(String args[]) {
    LongestSubstringWithAtMostKDistinctCharacters340 longest = new LongestSubstringWithAtMostKDistinctCharacters340();
    System.out.println(longest.lengthOfLongestSubstringKDistinct("eceba", 2));
  }

  /*public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new LinkedHashMap<>();
    int l = 0;
    int r = 0;
    int max = 0;
    while (r < s.length()) {

      char ch = s.charAt(r);
      map.put(ch, r + 1);
      if (map.size() > k) {
        Map.Entry<Character, Integer> leftmost = map.entrySet().iterator().next();
        map.remove(leftmost.getKey());
        l=leftmost.getValue()+1;
      }
      max=Math.max(r-l,max);
    }
    return max;
  }*/

  public int lengthOfLongestSubstringKDistinct(String s, int k) {
    int r = 0;
    int l = 0;
    int max = 0;

    Map<Character, Integer> map = new HashMap<>();

    while (r < s.length()) {
      char ch = s.charAt(r);
      map.put(ch, r + 1);
      if (map.size() > k) {

        int post = Collections.min(map.values());
        char c = s.charAt(post);
        map.remove(c);
        l = post+1;

      }
      max = Math.max(max, r - l + 1);
      r++;

    }
    return max;
  }



}
