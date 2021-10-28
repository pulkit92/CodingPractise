package array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public static void main(String args[]) {
    int nums[] = {1, 2, 3, 4};
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
    System.out.println(productOfArrayExceptSelf.productExceptSelf(nums));
  }

  public int[] productExceptSelf(int[] nums) {
    int a[] = new int[nums.length];
    Arrays.fill(a,1);

    int product = 1;
    for (int i = nums.length - 1; i > 0; i--) {
      product = product * nums[i];
      a[i - 1] = product;
    }
    product = 1;

    for (int i = 0; i < nums.length - 1; i++) {
      product = product * nums[i];
      a[i + 1] = product * a[i + 1];
    }
    return a;
  }

}
