package bfsAndDfsArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates {
  public void wallsAndGates(int[][] rooms) {
    for (int i = 0; i < rooms.length; i++) {
      for (int j = 0; j < rooms[0].length; j++) {
        if (rooms[i][j] == 2147483647) {
          rooms[i][j] = nearest(rooms, i, j);
        }
      }
    }
  }

  private int nearest(int[][] rooms, int i, int j) {
    int direction[][] = new int[rooms.length][rooms[0].length];
    List<int[]> dir = new ArrayList<>();
    dir.add(new int[] {0, -1});
    dir.add(new int[] {0, 1});
    dir.add(new int[] {1, 0});
    dir.add(new int[] {-1, 0});

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] {i, j});
    while (!queue.isEmpty()) {
      int post[] = queue.poll();
      int row = post[0];
      int col = post[1];
      for (int d[] : dir) {
        int x = row + d[0];
        int y = col + d[1];
        if (x < 0 || x >= rooms.length || y < 0 || y >= rooms[0].length || rooms[x][y] == -1 || direction[x][y] > 0) {
          continue;
        }
        direction[x][y] = direction[row][col] + 1;
        if (rooms[x][y] == 0) {
          return direction[x][y];
        }
        queue.add(new int[] {x, y});

      }
    }
    return 2147483647;
  }
}
