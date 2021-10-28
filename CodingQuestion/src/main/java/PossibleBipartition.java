import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PossibleBipartition {
  public boolean possibleBipartition(int N, int[][] dislikes) {
    boolean b[][] = new boolean[N + 1][N + 1];
    for (int x = 0; x < b.length; x++) {
      Arrays.fill(b[x], false);
    }

    for (int i = 0; i < dislikes.length; i++) {
      int x = dislikes[i][0];
      int y = dislikes[i][1];
      b[x][y] = true;
    }
    Set<Integer> a1 = new HashSet<>();
    Set<Integer> b1 = new HashSet<>();

      return true;
    }

    public static void main (String args[]){
      int a[][] = {{1, 2}, {1, 3}, {2, 4}};
      PossibleBipartition p = new PossibleBipartition();
      p.possibleBipartition(4, a);
    }
  }
