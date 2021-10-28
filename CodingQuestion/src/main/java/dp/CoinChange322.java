package dp;

public class CoinChange322 {
static int count =0;
  public int coinChange(int[] coins, int amount) {
    int memo[] = new int[amount + 1];
    return coinChange(coins, amount, memo);
  }

  private int coinChange(int[] coins, int amt, int memo[]) {
    if (amt == 0) {
      return 0;
    }
    if (amt < 0) {
      return -1;
    }

    if (memo[amt] != 0) {
      System.out.println("hereee");
      count ++;
      return memo[amt];
    }
    int minCount = Integer.MAX_VALUE;
    for (int i = 0; i < coins.length; i++) {
      int count = coinChange(coins, amt - coins[i], memo);
      if (count == -1) {
        continue;
      }
      minCount = Math.min(minCount, count + 1);
    }
    memo[amt] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
    return memo[amt];
  }


  public static void main(String args[]) {
    int coins[] = {186,419,83,408};
    int amount = 6249;
    CoinChange322 coinChange322 = new CoinChange322();
    System.out.println(coinChange322.coinChange(coins, amount));
  }
}
