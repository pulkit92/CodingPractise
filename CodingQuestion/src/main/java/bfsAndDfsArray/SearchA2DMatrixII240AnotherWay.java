package bfsAndDfsArray;

public class SearchA2DMatrixII240AnotherWay {
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
    int row = matrix.length-1;
    if (row <0) {
      return false;
    }
    if (matrix[0].length == 0) {
      return false;
    }
    int col = matrix[0].length;
    int i=0;
    while (row>=0 && i<col)
    {
      if(matrix[row][i]==target)
        return true;
      else if(matrix[row][i]>target)
        row--;
      else
        i++;
    }
    return false;
  }
}
