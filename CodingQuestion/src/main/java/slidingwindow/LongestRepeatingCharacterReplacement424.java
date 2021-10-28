package slidingwindow;

public class LongestRepeatingCharacterReplacement424 {
  public int characterReplacement(String s, int k) {
    int r = 0;
    int l = 0;
    int maxLen = 0;
    int maxCount = 0;
    int[] count = new int[26];
    while (r < s.length()) {
      char ch = s.charAt(r);
      maxCount = Math.max(maxCount, ++count[ch- 'A']);
      while (r - l + 1 - maxCount > k) {
        char c = s.charAt(l);
        count['A' - c]--;
        l++;
      }
      maxLen = Math.max(maxLen, r - l + 1);
      r++;
    }
    return maxLen;
  }

  public static void main(String args[]) {
    LongestRepeatingCharacterReplacement424 longestRepeatingCharacterReplacement424 =
        new LongestRepeatingCharacterReplacement424();
    System.out.println(longestRepeatingCharacterReplacement424.characterReplacement("AABABBA", 1));
  }
}
