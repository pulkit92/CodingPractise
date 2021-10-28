/*
public class MinimumPathSum {
  int min = Integer.MAX_VALUE;

  public int minPathSum(int[][] grid) {
    int grid1[][] = new int[grid.length][grid[0].length];
    minPathSum(grid, grid1, 0, 0, 0);
    return min;
  }

  void minPathSum(int[][] grid, int[][] memo, int i, int j, int sum) {
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      min = Math.min(sum + grid[i][j], min);
    } else if (i < grid.length && j < grid[0].length) {
      minPathSum(grid, memo, i + 1, j, sum + grid[i][j]);
      minPathSum(grid, memo, i, j + 1, sum + grid[i][j]);
      memo[i][j] =
    }
  }

  public static void main(String args[]) {
    int a[][] = {{1, 2, 5}, {3, 2, 1}};
    MinimumPathSum m = new MinimumPathSum();
    System.out.println(m.minPathSum(a));
  }
}
*/
