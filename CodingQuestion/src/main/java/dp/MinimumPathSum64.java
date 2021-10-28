package dp;

public class MinimumPathSum64 {
  /*public int minPathSum(int[][] grid) {
    int row = grid.length - 1;
    int col = grid[0].length - 1;
    int dp[][] = new int[row + 1][col + 1];
    for (int i = row; i >= 0; i--) {
      for (int j = col; j >= 0; j--) {
        int min = 0;
        if (j != col && i != row) {
          dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
          } else if (j == col && row != i) {
            dp[i][j] = grid[i][j] + dp[i + 1][j];
          } else if (row == i && j != col) {
          dp[i][j] = grid[i][j] + dp[i][j + 1];
        } else {
          dp[i][j] = grid[i][j];
        }

      }
    }
    return dp[0][0];
  }*/

  public static void main(String args[]) {
    MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
    int grid[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minimumPathSum64.minPathSum(grid));
  }

  public int minPathSum(int[][] grid) {
    int row = grid.length - 1;
    int col = grid[0].length - 1;
    int dp[][] = new int[row + 1][col + 1];
    for (int i = 0; i <= row; i++) {
      for (int j = 0; j <= col; j++) {
        if (j != 0 && i != 0) {
          dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
        } else if (j == 0 && i != 0) {
          dp[i][j] = grid[i][j] + dp[i - 1][j];
        } else if (j != 0 && i == 0) {
          dp[i][j] = grid[i][j] + dp[i][j - 1];
        } else {
          dp[i][j] = grid[i][j];
        }
      }
    }
    return dp[row][col];
  }
}
