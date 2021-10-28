package sort;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override public int compare(int[] o1, int[] o2) {
        return o1[0]-o1[1]-o2[0]-o2[1];
      }
    });
    int sum = 0;
    int pos = 0;
    for (int i = 0; i < costs.length; i++) {
      if (i == costs.length / 2) {
        pos = 1;
      }
      sum = sum + costs[i][pos];
    }
    return sum;
  }

  public static void main(String args[]){
    TwoCityScheduling twoCityScheduling=new TwoCityScheduling();
    int a[][]={{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
    System.out.println(twoCityScheduling.twoCitySchedCost(a));
  }
}


