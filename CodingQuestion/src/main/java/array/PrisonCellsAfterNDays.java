package array;

public class PrisonCellsAfterNDays {
  public int[] prisonAfterNDays(int[] cells, int N) {
   int x[]=cells;
    for (int i = 0; i < N; i++) {
      int y[]=new int[8];
      for (int j = 1; j <= 6; j++) {
        if (x[j - 1] == 0 && x[j + 1] == 0) {
          y[j] = 1;
        } else if (x[j - 1] == 1 && x[j + 1] == 1) {
          y[j] = 1;
        } else {
          y[j] = 0;
        }
      }
      x=y;
    }
    return x;
  }

  public static void main(String args[]) {
    int a[] = {1,0,0,1,0,0,1,0};

    PrisonCellsAfterNDays prisonCellsAfterNDays = new PrisonCellsAfterNDays();
    System.out.println(prisonCellsAfterNDays.prisonAfterNDays(a, 1000000000));
  }
}



