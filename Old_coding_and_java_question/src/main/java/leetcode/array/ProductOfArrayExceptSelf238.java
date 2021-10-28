package leetcode.array;

import java.util.Arrays;
import java.util.List;

public class ProductOfArrayExceptSelf238 {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int a[] = productExceptSelf(arr);
		for (int i : a)
			System.out.println(i);
	}

	public static int[] productExceptSelf(int[] nums) {
		int product = 1;
		int a[] = new int[nums.length];
		Arrays.fill(a, 1);
		for (int i = nums.length-2; i >= 0; i--) {
			product = product * nums[i + 1];
			a[i] = product;

		}
		product = 1;
		for (int i = 1; i < nums.length; i++) {
			product = product * nums[i - 1];
			a[i] =a[i]* product;

		}

		return a;

	}
}
