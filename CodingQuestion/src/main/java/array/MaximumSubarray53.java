package array;

public class MaximumSubarray53 {
  public int maxSubArray(int[] nums) {
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      sum = sum + nums[i];
      if(sum<0){
        sum=0;
      }
      if (sum > max) {
        max = sum;
      }
    }
    return max;

  }

  public static void main(String args[]) {
    MaximumSubarray53 s = new MaximumSubarray53();
    int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(s.maxSubArray(nums));
  }
}
