package leetcode;

public class search2dmatrix74 {
	public static void main(String[] args) {
		int N = 3;

		// Test Case 1
		//int mat[][] = { { -9, -7, -7, -5, -3 }, { 5, 7, 9, 11, 12 }, { 13, 14, 15, 16, 18 }, { 19, 21, 22, 22, 22 } };
int mat[][]= {{1,3,5}};
		System.out.println(searchMatrix(mat, 1));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		for (int i = 0; i < matrix.length; i++) {
			int len = matrix[i].length - 1;
			if (len < 0)
				return false;
			int a = matrix[i][len];
			if (a >= target) {
				if (target == a) {
					return true;
				} else {
					return searchMatrix(matrix[i], 0, len, target);

				}
			}

		}
		return false;
	}

	public static boolean searchMatrix(int[] a, int start, int end, int target) {
		while (end >= start) {
			int mid = (start + end) / 2;
			if (a[mid] == target)
				return true;
			else if (a[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}

		}
		return false;

	}

}
