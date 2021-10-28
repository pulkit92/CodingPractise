package bfsAndDfsArray;

import java.util.LinkedList;
import java.util.Queue;

public class MinDistanceBetween2Points {
  public static void main(String args[]) {

  }

  private int findDistanceBW2points(int a[][], int p, int q, int r, int s) {
    if (a[p][q] == 1 || a[q][r] == 1) {
      return -1;
    }
    int directions[][]={{0,1},{1,0}};
    int matrix[][]=new int[a.length][a[0].length];
    Queue<int[]> queue=new LinkedList<>();
    return 0;
  }
}
