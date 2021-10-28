package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> lists = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();

    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int x = i + 1;
      int y = n - 1;
      while (x < y) {
        int sum = nums[i] +  nums[x] + nums[y];
        if (sum == 0) {

          List<Integer> list = new ArrayList<>();
          list.add(nums[i]);
          list.add(nums[x]);
          list.add(nums[y]);
          if (!set.contains(list)) {
            lists.add(list);
            set.add(list);
          }
          x++;
          y--;
        } else if (sum < 0) {
          x++;
        } else {
          y--;
        }
      }
    }
    return lists;
  }



  public static void main(String args[]) {
    ThreeSum15 t = new ThreeSum15();
    int nums[] = {-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6};
    System.out.println(t.threeSum(nums));
  }
}
