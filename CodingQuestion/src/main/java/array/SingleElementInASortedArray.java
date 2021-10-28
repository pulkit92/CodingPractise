package array;

public class SingleElementInASortedArray {
  public int singleNonDuplicate(int[] nums) {
    int end = nums.length - 1;
    int start = 0;
    while (end >= start) {
      int mid = start + (end - start) / 2;
      if (mid > 0 && mid < nums.length && nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1]) {
        return nums[mid];
      } else if (mid > 0 && nums[mid - 1] == nums[mid]) {
        end = mid - 1;
      } else {
        start = mid + 1;

      }
    }
    return 0;

  }

  public static void main(String args[]) {
    int nums[] = {1, 1, 2, 3, 3, 4, 4, 8, 8};
    SingleElementInASortedArray s = new SingleElementInASortedArray();
    System.out.println(s.singleNonDuplicate(nums));
  }

}
