package dp;

import java.util.Arrays;

public class PerfectSquareDp {
  public int numSquares(int n) {
    int dp[] = new int[n + 1];

    Arrays.fill(dp, n + 1);
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        if (j*j <= i) {
          dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
      }
    }
    return dp[n] > n ? -1 : dp[n];

  }

  public static void main(String args[]) {
    PerfectSquareDp perfectSqaure = new PerfectSquareDp();
    System.out.println(perfectSqaure.numSquares(3));
  }
}

