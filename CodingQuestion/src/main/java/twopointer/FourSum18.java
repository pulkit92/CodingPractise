package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FourSum18 {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> lists = new LinkedList<>();
    Set<List<Integer>> set = new HashSet<>();


    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int k = i + 1; k < n; k++) {
        int x = k + 1;
        int y = n - 1;
        while (x < y) {
          int sum = nums[i] + nums[k] + +nums[x] + nums[y];
          if (sum == target) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[k]);
            list.add(nums[x]);
            list.add(nums[y]);
            if (!set.contains(list)) {
              lists.add(list);
              set.add(list);
            }
            x++;
            y--;
          } else if (sum < target) {
            x++;
          } else {
            y--;
          }
        }
      }
    }
    return lists;
  }

  public static void main(String args[]) {
    FourSum18 t = new FourSum18();
    int nums[] = {-3, -1, 0, 2, 4, 5};
    System.out.println(t.fourSum(nums, 2));
  }
}
