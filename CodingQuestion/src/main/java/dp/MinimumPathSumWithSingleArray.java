package dp;

import java.util.Map;

public class MinimumPathSumWithSingleArray {
  public static void main(String args[]) {
    MinimumPathSumWithSingleArray minimumPathSum64 = new MinimumPathSumWithSingleArray();
    int grid[][] = {{1, 2, 3}, {4,5,6}};
    System.out.println(minimumPathSum64.minPathSum(grid));
  }

  public int minPathSum(int[][] grid) {
    int col = grid[0].length;
    int dp[] = new int[col];
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (i == 0 && j == 0) {
          dp[j] = grid[i][j];
        } else if (i == 0) {
          dp[j] = dp[j-1] + grid[i][j];
        } else if (j == 0) {
          dp[j] = dp[j] + grid[i][j];
        } else {
          dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
        }
      }
    }
    return dp[dp.length - 1];
  }
}
