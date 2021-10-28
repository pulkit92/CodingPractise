package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum18 {
	public static void main(String[] args) {
		int arr[] = { 1, 0, -1, 0, -2, 2 };
		int tar = 0;
		List<List<Integer>> list = fourSum(arr, tar);
		System.out.println(list);

	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		int l = nums.length;
		for (int i = 0; i < l-3; i++) {
			for (int j = i+1; j < l-2; j++) {
				int x = j + 1;
				int y = l - 1;
				while (x < y) {
					int sum=nums[i] + nums[j] + nums[x] + nums[y];
					if (sum == target) {
						x++;
						y--;
						List<Integer> list1 = new ArrayList<>();
						list1.add(nums[i]);
						list1.add(nums[j]);
						list1.add(nums[x]);
						list1.add(nums[y]);
							Collections.sort(list1);
						list.add(list1);

					} else if (sum > target) {
						y--;
					} else {
						x++;
					}
				}

			}
		}
		return list;

	}
}
