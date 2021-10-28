package leetcode.array;

public class MaxAreaOfIsland695 {

	public static void main(String args[]) {
		int[][] grid = { { 1, 1, 0, 1, 1 }, 
						{ 1, 0, 0, 0, 0 }, 
						{ 0, 0, 0, 0, 1 }, 
						{ 1, 1, 0, 1, 1 } };

		System.out.println(maxAreaOfIsland(grid));
	}

	static int max = 0;
	static int count = 0;

	public static int maxAreaOfIsland(int[][] grid) {
		if (grid.length == 0)
			return 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					count = 0;
					maxAreaOfIsland(grid, i, j, grid.length - 1, grid[0].length - 1);
				}
			}
		}
		return max;

	}

	public static int maxAreaOfIsland(int[][] grid, int i, int j, int r, int c) {

		if ((i >= 0 && i <= r) && (j >= 0 && j <= c)) {
			if (grid[i][j] == 1) {
				count++;
				grid[i][j] = 0;
				if (count > max) {
					max = count;
				}
				maxAreaOfIsland(grid, i - 1, j, r, c);
				maxAreaOfIsland(grid, i + 1, j, r, c);
				maxAreaOfIsland(grid, i, j + 1, r, c);
				maxAreaOfIsland(grid, i, j - 1, r, c);
			}

		}
		return max;
	}

}
