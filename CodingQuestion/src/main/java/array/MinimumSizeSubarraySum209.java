package array;

public class MinimumSizeSubarraySum209 {
  public static void main(String arrgs[]) {

    int nums[] = {0, 1};
    MinimumSizeSubarraySum209 c = new MinimumSizeSubarraySum209();
    int a[] = {2, 3, 1, 2, 4, 3};
    // System.out.println(c.minSubArrayLen(4, a));
    System.out.println(c.minSubArrayLen2(7, a));

  }


  public int minSubArrayLen1(int[] nums, int k) {
    int sum = 0;
    int maxLen = Integer.MAX_VALUE;
    int r = 0;
    int l = 0;
    while (r < nums.length) {
      sum = sum + nums[r];
      while (r >= l && sum >= k) {
        maxLen = Math.min(maxLen, r - l + 1);
        sum = sum - nums[l];
        l++;
      }
      r++;
    }
    return maxLen == Integer.MAX_VALUE ? 0 : maxLen;
  }

  //https://leetcode.com/problems/minimum-size-subarray-sum/solution/
 /* int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
          sum += nums[k];
        }
        if (sum >= s) {
          ans = Math.max(ans, (j - i + 1));
          break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
        }
      }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
  }*/


  int minSubArrayLen2(int target, int[] nums) {
    int n = nums.length;
    int ans = Integer.MAX_VALUE;
    int sum = 0;
    int j = 0;
    for (int i = 0; i < n; i++) {
      while (j < nums.length) {
        sum = sum + nums[j];
        if (sum >= target) {
          ans = Math.min(ans, j - i + 1);
          sum=sum-nums[i];
          break;
        }
        j++;
      }
    }
    return (ans != Integer.MAX_VALUE) ? ans : 0;
  }
}
