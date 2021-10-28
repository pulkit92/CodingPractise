package math;

public class MinimumMovesToEqualArrayElements453 {
  public static void main(String[] nums) {
    MinimumMovesToEqualArrayElements453 minimumMovesToEqualArrayElements453 = new MinimumMovesToEqualArrayElements453();
    int a[] = {1, 3, 3,4,4,5};
    System.out.println(minimumMovesToEqualArrayElements453.minMoves(a));
  }

  public int minMoves(int[] nums) {
    int max = 0;
    int min = 0;
    int count = 0;
    while (true) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > nums[max]) {
          max = i;
        }
        if (nums[i] < nums[min]) {
          min = i;
        }
      }
      if (nums[max] == nums[min]) {
        break;
      }
      for (int i = 0; i < nums.length; i++) {
        if (i != max) {
          nums[i]++;
        }
      }
      count++;

    }
    return count;
  }
}
