package array;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK325 {
  public static void main(String args[]) {
    MaximumSizeSubarraySumEqualsK325 m = new MaximumSizeSubarraySumEqualsK325();
    int a[] = {1,-1,5,-2,3};
    System.out.println(m.maxSubArrayLen(a, 3));

  }

  public int maxSubArrayLen(int[] nums, int k) {
    int maxLen = 0;
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(k, 0);
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if (map.containsKey(sum - k)) {
        maxLen = Math.max(maxLen, i - map.get(sum - k));
      }
      map.put(sum, i);
    }

    return maxLen;
  }
}
