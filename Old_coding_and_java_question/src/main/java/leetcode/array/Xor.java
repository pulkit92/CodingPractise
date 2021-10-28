package leetcode.array;

public class Xor {

	public static void main(String args[]) {
		int[] grid = { 4, 3, 2, 7, 8, 2, 3, 1 };
		int xor = 1;
		for (int i = 0; i < grid.length; i++) {
			xor^=grid[i];
		}
		System.out.println(xor);
	}
}