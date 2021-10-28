package dp;

public class LongestPalindromicSubstringExpnadFrmCenter {

  public String longestPalindrome(String s) {
    int d[] = new int[3];

    for (int i = 0; i < s.length(); i++) {
      int temp[] = expandFrmCenter(s, i, i);
      int temp1[] = expandFrmCenter(s, i, i + 1);
      int max[] = temp[2] > temp1[2] ? temp : temp1;
      if (max[2] > d[2]) {
        d[0] = max[0];
        d[1] = max[1];
        d[2] = max[2];
      }

    }
    return s.substring(d[0]+1,d[1]);
  }

  public int[] expandFrmCenter(String s, int left, int right) {
    int d[] = new int[3];

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    d[0] = left;
    d[1] = right;
    d[2] = right - left - 1;

    return d;
  }
  //"abcba"
  //cbasxb


  public static void main(String args[]) {
    LongestPalindromicSubstringExpnadFrmCenter longestPalindromicSubstring =
        new LongestPalindromicSubstringExpnadFrmCenter();
    System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
  }
}
