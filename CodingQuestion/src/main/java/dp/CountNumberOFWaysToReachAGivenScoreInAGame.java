package dp;

import java.util.Arrays;

public class CountNumberOFWaysToReachAGivenScoreInAGame {
  public  static int  combinationSum4(int[] nums, int target) {
    int[] dp = new int[target + 1];
    Arrays.fill(dp, -1);
    return backtrack(nums, target, dp, 0);
  }

  private  static int backtrack(int[] nums, int target, int[] dp, int sum) {
    if (sum > target)
      return 0;
    if (sum == target)
      return 1;
    if (dp[sum] != -1)
      return dp[sum];
    int count = 0;
    for (int num : nums)
      count += backtrack(nums, target, dp, sum + num);
    dp[sum] = count;
    return dp[sum];
  }

  public static void main(String[] args) {
    int n = 8;
    int a[]={2,4,6};
    System.out.println("Count for " + n + " is " + combinationSum4(a,n));


  }
}
