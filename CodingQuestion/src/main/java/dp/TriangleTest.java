package dp;

import java.util.ArrayList;
import java.util.List;

public class TriangleTest {
  public int minimumTotal(List<List<Integer>> triangle) {
    List<List<Integer>> dp = new ArrayList<>();
    for (int i = 0; i < triangle.size(); i++) {
      List<Integer> colList = triangle.get(i);
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < colList.size(); j++) {
        if (j == 0 && i == 0) {
          temp.add(colList.get(0));
        }
        else if (j == 0) {
          List<Integer> prev = dp.get(i - 1);
          int x = prev.get(j);
          temp.add(colList.get(0)+x);

        } else {
          List<Integer> prev = dp.get(i - 1);
          int x = prev.get(j - 1);
          int y = Integer.MAX_VALUE;
          if (prev.size() > j) {
            y = prev.get(j);

          }
          temp.add(Math.min(x, y) + colList.get(j));

        }

      }
      dp.add(temp);
    }
    int min = Integer.MAX_VALUE;
    for (int min_y : dp.get(dp.size() - 1)) {
      min = Math.min(min_y, min);
    }
    return min;
  }

  public static void main(String args[]) {
    TriangleTest t = new TriangleTest();
    List<List<Integer>> triangle = new ArrayList<>();
    List<Integer> list1 = new ArrayList<>(List.of(2));
    List<Integer> list2 = new ArrayList<>(List.of(3, 4));
    List<Integer> list3 = new ArrayList<>(List.of(6, 5, 7));
    List<Integer> list4 = new ArrayList<>(List.of(4, 1, 8, 3));
    triangle.add(list1);
    triangle.add(list2);

    triangle.add(list3);

    triangle.add(list4);

    System.out.println(t.minimumTotal(triangle));
  }
}