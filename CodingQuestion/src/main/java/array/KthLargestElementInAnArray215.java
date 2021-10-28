package array;

public class KthLargestElementInAnArray215 {

  public int findKthLargest(int[] nums, int k) {
    int nonLeafyPos = (nums.length / 2) - 1;
    for (int i = nonLeafyPos; i >= 0; i--) {
      heafify(i, nums, nums.length - 1);
    }
    int l = nums.length - 1;
    for (int i = 0; i < k - 1; i++) {
      nums[0] = nums[l];
      l--;
      heafify(0, nums, l);
    }
    return nums[0];
  }

  public void heafify(int i, int a[], int l) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    if (l < left && a[left] > a[right]) {
      swap(a, i, left);
      heafify(left, a, l);
    } else if (l < right) {
      swap(a, i, right);
      heafify(right, a, l);
    }
  }

  void swap(int a[], int i, int pos) {
    int temp = a[i];
    a[i] = a[pos];
    a[pos] = temp;
  }

  public static void main(String[] args) {
    int a[] = {3, 1, 2, 4};
    KthLargestElementInAnArray215 k = new KthLargestElementInAnArray215();
    System.out.println(k.findKthLargest(a, 2));
  }

}

