package leetcode.matrix;

public class SearchA2DMatrixII240 {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0)
			return false;
		int a = matrix.length - 1;
		int b = matrix[0].length - 1;
		int i = 0;
		while (a >= 0 && i <= b) {
			int x = matrix[a][i];
			if (x == target)
				return true;
			else if (x > target)
				a--;
			else
				i++;
		}
		return false;
	}
	public static void main(String[] args) {
		int arr[][] = {};
		System.out.println(searchMatrix(arr, 20));
	}

}
