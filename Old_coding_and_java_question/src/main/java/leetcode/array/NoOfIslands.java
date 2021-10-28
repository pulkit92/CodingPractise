package leetcode.array;

public class NoOfIslands {
	public static void main(String[] args) {

		char mat[][] = { {'1'},{'1'}};
		System.out.println(numIslands(mat));
	}

	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) 
			return 0;
		int count = 0;
		boolean b[][] = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && b[i][j] == false) {
					booleancheck(i, j, b, grid);
					count++;
				}
			}
		}

		return count;
	}

	public static void booleancheck(int i, int j, boolean b[][], char grid[][]) {
		if (grid[i][j] == '1' && b[i][j] == false) {
			b[i][j] = true;
			if (i != grid.length - 1)
				booleancheck(i + 1, j, b, grid);
			if (i != 0)
				booleancheck(i - 1, j, b, grid);
			if (j != grid[0].length - 1)
				booleancheck(i, j + 1, b, grid);
			if (j != 0)
				booleancheck(i, j - 1, b, grid);
		}
	}
}
