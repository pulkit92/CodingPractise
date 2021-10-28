package array;

public class FirstMissingPositive41 {
  public int firstMissingPositive(int[] nums) {
    if (nums.length == 0) {
      return 1;
    }
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= 0) {
        nums[i] = nums.length;
      }
    }
    for (int i = 0; i < nums.length; i++) {
      int k = Math.abs(nums[i]);
      if (k <= nums.length && nums[k - 1] >= 0) {
        nums[k - 1] = -nums[k - 1];
      }
    }
    for (int i = 1; i <= nums.length; ++i) {
      if (nums[i - 1] > 0) {
        return i;
      }
    }
    return nums.length + 1;
  }
 /* public int firstMissingPositive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] < 0) {
        nums[i] = nums.length;
      }
    }
    int i = 1;
    for (; i <= nums.length; i++) {
      if (!set.contains(i)) {
        return i;
      }
    }
    return i;
  }*/

  public static void main(String args[]) {
    FirstMissingPositive41 f = new FirstMissingPositive41();
    int[] nums = {1};
    System.out.println(f.firstMissingPositive(nums));
  }
}
