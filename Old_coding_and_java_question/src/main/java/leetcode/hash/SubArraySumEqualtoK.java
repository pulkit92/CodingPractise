package leetcode.hash;

import java.util.HashMap;

public class SubArraySumEqualtoK {
	public static void main(String[] args) {
		SubArraySumEqualtoK count = new SubArraySumEqualtoK();
		int arr[] = { 3, 4, 7, 2, -3, 1, 4, 2 };
		System.out.println(count.subarraySum(arr, 7));
	}

	public int subarraySum(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
