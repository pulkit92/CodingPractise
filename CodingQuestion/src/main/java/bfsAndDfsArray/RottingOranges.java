package bfsAndDfsArray;

import java.util.HashSet;
import java.util.Set;

public class RottingOranges {
  int min = 0;
  int count1 = 0;

  public int orangesRotting(int[][] grid) {
    Set<String> rotten = new HashSet<>();
    Set<String> fresh = new HashSet<>();


    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          fresh.add(i + "," + j);
        } else if (grid[i][j] == 2) {
          rotten.add(i + "," + j);
        }
      }
    }
    int min = 0;
    int dir[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    while (fresh.size() > 0) {
      Set<String> infected = new HashSet<>();
      for (String s : rotten) {
        String[] sp = s.split(",");
        int i = Integer.parseInt(sp[0]);
        int j = Integer.parseInt(sp[1]);
        for (int directions[] : dir) {
          int x = i + directions[0];
          int y = j + directions[1];
          String key = x + "," + y;
          if (fresh.contains(key)) {
            fresh.remove(key);
            infected.add(key);
          }

        }


      }
      if (infected.size() == 0) {
        return -1;
      }
      rotten = infected;
      min++;
    }
    return min;
  }

  public static void main(String args[]) {
    RottingOranges rottingOranges = new RottingOranges();
    int a[][] = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
    System.out.println(rottingOranges.orangesRotting(a));
  }
}
