package dp;

import java.util.Arrays;

public class CoinChangeBottomUp {
  public static void main(String args[]) {
    int coins[] = {2};
    int amount = 3;
    CoinChangeBottomUp coinChangeBottomUp = new CoinChangeBottomUp();
    System.out.println(coinChangeBottomUp.coinChange(coins, amount));
  }


  private int coinChange(int[] coins, int amount) {
    int dp[] = new int[amount + 1];

    Arrays.fill(dp, amount+1);
    dp[0]=0;

    for (int i = 1; i <= amount; i++) {
      for (int coinValue : coins) {
        if (coinValue <= i) {
          dp[i] = Math.min(dp[i], dp[i - coinValue] + 1);
        }
      }

    }
    return dp[amount] > amount ? -1 : dp[amount];

  }

}

