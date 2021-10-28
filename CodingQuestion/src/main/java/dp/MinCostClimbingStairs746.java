package dp;

import java.util.Arrays;

public class MinCostClimbingStairs746 {

  public int minCostClimbingStairs(int[] cost) {
    if (cost == null || cost.length == 0) {
      return 0;
    }
    int a[] = new int[cost.length];
    Arrays.fill(a, -1);
    return Math.min(minCostClimbingStairs(cost, cost.length - 1, a), minCostClimbingStairs(cost, cost.length - 2, a));
  }

  public int minCostClimbingStairs(int[] cost, int l, int a[]) {
    if (l == 0) {
      return cost[0];
    } else if (l == 1) {
      return cost[1];
    } else if (a[l] == -1) {
      a[l] = cost[l] + Math.min(minCostClimbingStairs(cost, l - 1, a), minCostClimbingStairs(cost, l - 2, a));
      return a[l];
    } else {
      return a[l];
    }
  }



  public static void main(String[] args) {
    MinCostClimbingStairs746 m = new MinCostClimbingStairs746();
    int cost[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    System.out.println(m.minCostClimbingStairs(cost));
  }
}
