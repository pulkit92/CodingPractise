import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
  public static void main(String args[]) {
    TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
    int a[][] = {{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}};
    twoCityScheduling.twoCitySchedCost(a);
  }

  public int twoCitySchedCost(int[][] costs) {
    Comparator<int[]> comparator = (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1]);
    Arrays.sort(costs, comparator);

    int c1 = 0;
    int c2 = 0;
    int sum = 0;
    int i = 0;
    int N = costs.length / 2;
    while (i < N * 2) {
      if (costs[i][0] < costs[i][1] && c1 < N || c2 == N) {

        sum = sum + costs[i][0];
        i++;
        c1++;
      } else {
        sum = sum + costs[i][1];
        c2++;
        i++;
      }
    }
    return sum;
  }
}

