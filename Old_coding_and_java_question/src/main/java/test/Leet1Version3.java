package test;

import java.util.HashMap;
import java.util.Map;

public class Leet1Version3 {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> s = new HashMap<>();

		int a[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int x = target - nums[i];
			if (s.containsKey(x)) {
				a[1] = i;
				a[0] = s.get(x);
			}
			s.put(nums[i],i);

		}
		return a;
	}

	public static void main(String args[]) {
		int a[] = { -3, 4, -5, 3, 90 };
		int n = 0;
		int a1[] = twoSum(a, n);
		for (int i = 0; i < 2; i++)
			System.out.println(a1[i]);
	}
}
