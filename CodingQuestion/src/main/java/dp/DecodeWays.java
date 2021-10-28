package dp;

public class DecodeWays {
  public int numDecodings(String s) {
    return countWays(s, s.length(), new int[s.length()]);
  }

  public int countWays(String s, int post, int memo[]) {
    int count = 0;
    if (s.charAt(0) == '0') {
      return 0;
    }
    if (post <= 0 || post == 1) {
      return 1;
    }
    if (memo[post-1]!=0){
      return memo[post-1];
    }
    if (s.charAt(post - 1) != '0') {
      count = countWays(s, post - 1, memo);
    }
    if (s.charAt(post - 2) == '1' || (s.charAt(post - 2) == '2' && Character.getNumericValue(s.charAt(post - 1))
        <= 6)) {
      count = count + countWays(s, post - 2, memo);

    }
    memo[post - 1] = count;
    return count;
  }

  public static void main(String args[]) {
    DecodeWays decodeWays = new DecodeWays();
    System.out.println(decodeWays.numDecodings("12"));
  }
}
