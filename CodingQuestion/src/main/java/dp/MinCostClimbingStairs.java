package dp;

public class MinCostClimbingStairs {
  int value;

  public int minCostClimbingStairs(int[] cost) {
    int dp[] = new int[cost.length + 1];
    dp[0] = cost[0];
    dp[1] = cost[1];
    find(dp, cost, 2);
    return dp[dp.length - 1];
  }

  public void find(int dp[], int cost[], int i) {
    if (i == dp.length - 1) {
      dp[i] = Math.min(dp[i - 1], dp[i - 2]);
      return;
    }
    dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
    find(dp, cost, i + 1);
  }

  public static void main(String args[]) {
    int cost[] = {10,15,20};
    MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
    System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
  }
}
