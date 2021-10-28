package array;

public class NextPermutation31 {
  public static void main() {
    int a[] = {1, 2, 3};
    NextPermutation31 n = new NextPermutation31();
    n.nextPermutation(a);
  }

  public void nextPermutation(int[] nums) {
    for (int i = nums.length - 1; i > 0; i--) {
      if (nums[i] > nums[i - 1]) {
        swap(nums, i, i - 1);
      }
    }

  }

  public void reverse(int a[]) {
    int n = a.length;
    int i, k, t;
    for (i = 0; i < n / 2; i++) {
      t = a[i];
      a[i] = a[n - i - 1];
      a[n - i - 1] = t;
    }
  }

  public void swap(int a[], int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

}
