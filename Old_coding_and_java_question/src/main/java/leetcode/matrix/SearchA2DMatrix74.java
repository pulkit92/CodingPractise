package leetcode.matrix;

public class SearchA2DMatrix74 {
	public static void main(String[] args) {
		int arr[][] = { { 1 } };
		System.out.println(searchMatrix(arr, 1));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0)
			return false;
		int a = matrix.length - 1;
		int b = matrix[0].length - 1;
		int i = 0;
		while (i <= a && b >= 0) {
			if (matrix[i][b] == target)
				return true;
			else if (target > matrix[i][b]) {
				i++;
			} else {
				b--;
			}
		}
		return false;

	}

}
