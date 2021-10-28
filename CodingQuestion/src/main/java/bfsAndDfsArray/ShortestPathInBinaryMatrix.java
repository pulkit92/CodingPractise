package bfsAndDfsArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public static void main(String args[]) {
        int grid[][] ={{0,1},{1,0}};
        ShortestPathInBinaryMatrix shortestPathInBinaryMatrix = new ShortestPathInBinaryMatrix();
        System.out.println(
                shortestPathInBinaryMatrix.shortestPathBinaryMatrix(grid)
        );
    }

    int minPath = Integer.MAX_VALUE;

    public int shortestPathBinaryMatrix(int[][] grid) {
        List<int[]> directions = new ArrayList<>(List.of(
                new int[]{-1, -1}, new int[]{-1, 0}, new int[]{-1, 1}, new int[]{0, 1},
                new int[]{1, 1}, new int[]{1, -1}, new int[]{1, 0}, new int[]{0, -1}));
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        queue.add(null);
        grid[0][0]=1;
        int sum = 0;
        if(grid[0][0] !=0 && grid[grid.length-1][grid[0].length-1]!=0){
            return -1;
        }
        while (!queue.isEmpty()) {
            int a[] = queue.poll();
            if (a == null) {
                sum = sum + 1;
                continue;
            }
            int i = a[0];
            int j = a[1];
            if (i == grid.length - 1 && j == grid[0].length - 1 ) {
                return sum+1;
            } else {
                for (int arr[] : directions) {
                    int x = arr[0] + i;
                    int y = arr[1] + j;
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 0) {
                        queue.add(new int[]{x, y});
                        grid[x][y] = 1;
                    }
                }
                queue.add(null);
            }
        }
        return -1;

    }

    private void dfs(int[][] grid, int i, int j, int sum) {
        if (i == grid.length - 1 && j == grid[0].length - 1 && grid[i][j] == 0) {
            sum = sum + 1;
            minPath = Math.min(sum, minPath);
            System.out.println(sum);
            return;
        }
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 0) {
            sum = sum + 1;
            grid[i][j] = 1;

            dfs(grid, i - 1, j - 1, sum);
            dfs(grid, i - 1, j, sum);
            dfs(grid, i - 1, j + 1, sum);
            dfs(grid, i, j + 1, sum);
            dfs(grid, i + 1, j + 1, sum);
            dfs(grid, i + 1, j, sum);
            dfs(grid, i + 1, j - 1, sum);
            dfs(grid, i, j - 1, sum);
            grid[i][j] = 0;
        }

    }

}
