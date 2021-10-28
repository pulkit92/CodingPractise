package dp;

public class MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    int max = 0;
    int row = matrix.length;
    int col = matrix[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
          max = Math.max(findlength(matrix, i, j, row, col), max);

        }
      }
    }
    return max;
  }

  public int findlength(char[][] matrix, int i, int j, int row, int col) {
    int newcol = j;
    int newrow = i;
    int col1 = j + 1;

    for (int temp = i + 1; temp < row; temp++) {
      if (col1 >= 0 && col1 < col) {
        if (matrix[temp][col1] == '1') {
          col1++;
          newcol++;
          newrow++;
        }
      }
    }

    for (int k = i; k <= newrow; k++) {
      for (int m = j; m <= newcol; m++) {
        if (matrix[k][m] != '1') {
          return 0;
        }
      }
    }
    return (newrow - i+1) * (newrow - i+1);

  }
  public static void main(String args[]) {
    MaximalSquare dungeonGame = new MaximalSquare();
    char grid[][] = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
    System.out.println(dungeonGame.maximalSquare(grid));
  }

}
