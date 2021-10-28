package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle {
  /* public int minimumTotal(List<List<Integer>> triangle) {
     List<Integer> prevRow = triangle.get(0);
     for (int i = 1; i < triangle.size(); i++) {
       List<Integer> currRow = new ArrayList<>();
       for (int j = 0; j < triangle.get(i).size(); j++) {
         int max = Integer.MAX_VALUE;
         if (j > 0) {
           max = prevRow.get(j - 1);
         }
         if (i > j) {
           max = Math.min(max, prevRow.get(j));
         }
         currRow.add(max + triangle.get(i).get(j));
       }
       prevRow=currRow;
     }
     return Collections.min(prevRow);
   }*/
  public int minimumTotal(List<List<Integer>> triangle) {
    List<Integer> prevRow = triangle.get(triangle.size()-1);
    for (int i = triangle.size() - 2; i >= 0; i--) {
      List<Integer> currRow = new ArrayList<>();
      for (int j = 0; j < triangle.get(i).size(); j++) {
        int minSoFar = Math.min(prevRow.get(j + 1), prevRow.get(j));
        currRow.add(minSoFar + triangle.get(i).get(j));
      }
      prevRow = currRow;
    }
    return Collections.min(prevRow);
  }

  public static void main(String args[]) {
    Triangle t = new Triangle();
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

//i==0
// i==j
//j==0
//min
