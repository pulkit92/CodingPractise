package twopointer;

import java.util.Arrays;

public class ThreeSumClosest15 {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int x = Integer.MAX_VALUE;
    int u = 0;
    for (int i = 0; i < nums.length - 1; i = i + 1) {
      int p = i + 1;
      int q = nums.length - 1;
      while (p < q) {
        int sum = nums[i] + nums[p] + nums[q];
        if (Math.abs(target - sum) < x) {
          x = Math.abs(target - sum);
          u = sum;
        }
        if (sum == 0) {
          p++;
          q--;
        } else if (sum < target) {
          p++;
        } else {
          q--;
        }
      }
    }
    return u;
  }

  public static void main(String args[]) {
    ThreeSumClosest15 t = new ThreeSumClosest15();
    int nums[] = {1, 2, 4, 8, 16, 32, 64, 128};
    System.out.println(t.threeSumClosest(nums, 82));
  }
}
