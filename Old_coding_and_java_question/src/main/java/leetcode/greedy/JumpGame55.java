package leetcode.greedy;

public class JumpGame55 {
  public boolean canJump(int[] nums) {
    int k = 0;
    while (k < nums.length) {
      if (nums[k] == 0 && k != nums.length - 1) {
        break;
      } else {
        if(k==nums.length-1)
          break;
        int t = nums[k];
        k = k + t;
      }

    }
    if (k == nums.length - 1 || k>=nums.length) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String args[]) {
    int a[] = {3,2,1,0,4};
    JumpGame55 j = new JumpGame55();

    System.out.println(j.canJump(a));
  }
}
