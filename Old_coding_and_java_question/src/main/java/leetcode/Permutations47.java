package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations47 {
	public static void main(String[] args) {
		int arr[] = { 1,1, 2 };
		List<List<Integer>> list = permuteUnique(arr);
		for (List<Integer> l : list) {
			System.out.println(l);
		}
	}

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Set<List<Integer>> list = new HashSet<>();
		List<List<Integer>> list1 = new ArrayList<>();
		list1.addAll(backtrack(list, new ArrayList<>(),  new ArrayList<>(),nums));
		return list1;
	}

	public static Set<List<Integer>> backtrack(Set<List<Integer>> list2, List<Integer> list,List<Integer> post, int[] nums) {
		if (list.size() == nums.length) {
			List<Integer> l=new ArrayList<>(list);
			
			if(!list.contains(l)) {
				list2.add(l);
			}
			return list2;
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (!post.contains(i)) {
					list.add(nums[i]);
					post.add(i);
					backtrack(list2, list,post, nums);
					list.remove(list.size() - 1);
					post.remove(post.size()-1);
				}

			}

		}
		return list2;

	}
}
