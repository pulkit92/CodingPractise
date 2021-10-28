import java.util.HashSet;
import java.util.Set;

public class GFGBooleanMatrix1 {
	public static void main(String[] args) {
		int mat[][] = { { 1, 0, 0, 1 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, };

		System.out.println("Matrix Intially");

		// printMatrix(mat, 3, 4);

		modifyMatrix(mat, 3, 4);
		System.out.println("Matrix after modification n");
		// printMatrix(mat, 3, 4);

	}

	static void modifyMatrix(int mat[][], int row, int col) {

		int b[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (mat[i][j] == 1) {
					for (int k = 0; k < row; k++) {
						b[k][j] = 1;
					}
					for (int k = 0; k < col; k++) {
						b[i][k] = 1;
					}
				}
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(b[i][j] + " ");
				;
			}

			System.out.println();
		}

	}

}

class Solution {
	public int removeDuplicates(int[] nums) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			s.add(nums[i]);
		}

		return s.size();
	}
}
