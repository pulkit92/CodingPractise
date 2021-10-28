package test;

import java.util.LinkedHashSet;
import java.util.Set;

class Leet1 {
	public static int[] twoSum(int[] nums, int target) {
		Set<Integer> s = new LinkedHashSet<>();
		int neg = greatestNegative(nums);
		if (neg > 0) {
			for (int i = 0; i < nums.length; i++)
				nums[i] = nums[i] + neg;
		}
		target = target + neg;
		int a[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (x > 0 && s.contains(x)) {
				a[1] = i;
				int p = 0;
				for (int s1 : s) {
					if (s1 == x) {
						a[0] = p;
						break;
					} else {
						p++;
					}
				}
			}
			s.add(nums[i]);
		}
		return a;
	}

	public static void main(String args[]) {
		int a[] = { -3, 4, -5,3, 90 };
		int n = 0;
		int a1[] = twoSum(a, n);
		for (int i = 0; i < 2; i++)
			System.out.println(a1[i]);
	}

	public static int greatestNegative(int[] a) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				if (result == 0 || a[i] < result) {
					result = a[i];
				}
			}
		}
		return result * -1;
	}
}