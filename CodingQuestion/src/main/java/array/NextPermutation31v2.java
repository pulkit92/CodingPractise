package array;

public class NextPermutation31v2 {
  public void nextPermutation(int[] nums) {
    int n = nums.length - 1;
    while (n > 0 && nums[n] > nums[n - 1]) {
      n--;
    }
    int i=n-1;
    while (i<nums.length){

    }

  }

  private void replace(int i, int j, int nums[]) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String args[]) {
    NextPermutation31v2 nextPermutation31v2 = new NextPermutation31v2();
    int nums[] = {1, 2, 3};
    nextPermutation31v2.nextPermutation(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
