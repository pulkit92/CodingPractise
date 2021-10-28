package jumpgame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JumpGame55 {
  public boolean canJump(int[] nums) {
    return canJump(nums, 0);
  }

  boolean canJump(int nums[], int i) {

    if (i >= nums.length - 1) {
      return true;
    }
    int t = nums[i];
    for (int j = 1; j <= t; j++) {
      if (canJump(nums, i + j)) {
        return true;
      }
    }

    return false;
  }


  public static void main(String args[]) {
    List<Integer> integers = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      integers.add(null);

      integers.add(i);
    }
    integers = integers.stream().limit(40).collect(Collectors.toList());
    for (int i : integers) {
      System.out.println(i);
    }
    int a[] = {2, 5, 0, 0};
    JumpGame55 jumpGame55 = new JumpGame55();
    //System.out.println(jumpGame55.canJump(a));
  }
}
