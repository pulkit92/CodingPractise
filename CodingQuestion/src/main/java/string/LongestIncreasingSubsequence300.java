package string;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
  public int lengthOfLIS(int[] nums) {
    int memo[][] = new int[nums.length + 1][nums.length];
    for (int[] l : memo) {
      Arrays.fill(l, -1);
    }
    return lengthofLIS(nums, -1, 0, memo);
  }

  public int lengthofLIS(int[] nums, int previndex, int curpos, int[][] memo) {
    if (curpos == nums.length) {
      return 0;
    }
    if (memo[previndex + 1][curpos] >= 0) {
      return memo[previndex + 1][curpos];
    }
    int taken = 0;
    if (previndex < 0 || nums[curpos] > nums[previndex]) {
      taken = 1 + lengthofLIS(nums, curpos, curpos + 1, memo);
    }

    int nottaken = lengthofLIS(nums, previndex, curpos + 1, memo);
    memo[previndex + 1][curpos] = Math.max(taken, nottaken);
    return memo[previndex + 1][curpos];
  }

  public static void main(String args[]) {
    int a[] = {10, 9, 2, 5, 3, 7, 101, 18};
    LongestIncreasingSubsequence300 longestIncreasingSubsequence300 = new LongestIncreasingSubsequence300();
    System.out.println(longestIncreasingSubsequence300.lengthOfLIS(a));
  }

}
