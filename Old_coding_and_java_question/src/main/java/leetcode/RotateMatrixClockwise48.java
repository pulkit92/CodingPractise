package leetcode;

public class RotateMatrixClockwise48 {
	static void displayMatrix(int N, int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + mat[i][j]);

			System.out.print("\n");
		}
		System.out.print("\n");
	}

	public static void rotate(int[][] matrix) {
		int N = matrix.length;
		for (int x = 0; x < N / 2; x++) {
			for (int y = x; y < N - 1 - x; y++) {
				int temp = matrix[x][y];
				matrix[x][y]=matrix[N-1-y][x];
				matrix[N-1-y][x]=matrix[N-1-x][N-1-y];
				matrix[N-1-x][N-1-y]=matrix[y][N-1-x];	
				matrix[y][N-1-x]=temp;
			
			}
		

		}

	}
	/* Driver program to test above functions */
	public static void main(String[] args) {
		int N = 3;

		// Test Case 1
		int mat[][] = { { 1, 2, 3}, { 4, 5, 6 }, { 7, 8, 9 } };

		// Tese Case 2
		/*
		 * int mat[][] = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
		 */

		// Tese Case 3
		/*
		 * int mat[][] = { {1, 2}, {4, 5} };
		 */

		// displayMatrix(mat);

		rotate(mat);

		// Print rotated matrix
		displayMatrix(N, mat);
	}
}
