package leetcode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode3Sum {

	public static void main(String[] args) {
		int arr[] = { -1, 0, 1, 2, -1, -4 };
		List<List<Integer>> list = threeSum(arr);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		int l = nums.length;
		Set<List<Integer>> list = new HashSet<>();
		for (int i = 0; i < l - 2; i++) {
			int j = i + 1;
			int k = l - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					List<Integer> list1 = new ArrayList<>();

					list1.add(nums[i]);
					list1.add(nums[j]);
					list1.add(nums[k]);
					list.add(list1);

					j++;
					k--;
				} else if (nums[i] + nums[j] + nums[k] >= 0) {
					k--;
				} else {
					j++;
				}
			}
			
			

		}

		return new ArrayList<List<Integer>>(list);
	}

}
