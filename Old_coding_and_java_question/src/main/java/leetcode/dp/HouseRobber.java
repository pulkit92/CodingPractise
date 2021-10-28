package leetcode.dp;

public class HouseRobber {
  public int rob(int[] nums) {

    if (rob(nums, 1) > rob(nums, 0)) {
      return rob(nums, 1);
    }
    return rob(nums, 0);
  }

  public int rob(int[] nums, int pos) {

return 1;
  }


  public static void main(String[] args) {
    int a[] = {2, 7, 9, 3, 1};
    HouseRobber h = new HouseRobber();
    System.out.println(h.rob(a));

  }
}
