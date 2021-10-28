package bfsAndDfsArray;

public class SearchA2DMatrixII240 {
  public static void main(String args[]) {
    SearchA2DMatrixII240 s = new SearchA2DMatrixII240();
    int matrix[][] = {{1, 4, 7, 11, 15},
        {2, 5, 8, 12, 19},
        {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    System.out.println(s.searchMatrix(matrix, 5));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int row = matrix.length;
    if (row == 0) {
      return false;
    }
    if (matrix[0].length == 0) {
      return false;
    }
    int col = matrix[0].length;
    return searchMatrix(matrix, target, row, col, 0, 0);
  }

  public boolean searchMatrix(int[][] matrix, int target, int row, int col, int i, int j) {
    if (row > i && col >j) {
      if (matrix[i][j] == target) {
        return true;
      } else if (target > matrix[i][j]) {
        boolean b = searchMatrix(matrix, target, row, col, i + 1, j);
        if (b == true) {
          return true;
        } else {
          return searchMatrix(matrix, target, row, col, i, j + 1);
        }
      } else {
        i = i + 1;
        j = j + 1;
      }
    }
    return false;
  }
}
