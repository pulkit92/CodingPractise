package dp;

public class DungeonGame {
  public static void main(String args[]) {
    DungeonGame dungeonGame = new DungeonGame();
    int grid[][] = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
    System.out.println(dungeonGame.calculateMinimumHP(grid));
  }

  public int calculateMinimumHP(int[][] dungeon) {
    int[][] dp = new int[dungeon.length][dungeon[0].length];
    int row = dungeon.length - 1;
    int col = dungeon[0].length - 1;

    for (int i = row; i >= 0; i--) {
      for (int j = col; j >= 0; j--) {
        int rightValue = minPoints(dungeon[i][j], i, j + 1, dp, dungeon);
        int downValue = minPoints(dungeon[i][j], i + 1, j, dp, dungeon);
        int value = Math.min(rightValue, downValue);
        if (value != Integer.MAX_VALUE) {
          dp[i][j] = Math.min(rightValue, downValue);
        } else {

          dp[i][j] = dungeon[i][j] < 0 ? (1 - dungeon[i][j])  : 1;
        }

      }
    }

    return dp[0][0];
  }

  private int minPoints(int currcell, int row, int col, int dp[][], int dungeon[][]) {
    if (row >= dungeon.length || col >= dungeon[0].length) {
      return Integer.MAX_VALUE;
    }
    int nextCell = dp[row][col];
    return Math.max(1, nextCell - currcell);
  }

}


