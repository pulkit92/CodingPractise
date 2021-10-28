/*
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TopKfrequent347 {
	public static void main(String[] args) {
		int arr[] = { 1, 2 };
		List<Integer> list = topKFrequent(arr, 2);
		for (Integer l : list) {
			System.out.println(l);
		}

	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 1;
		List<Integer> list = new ArrayList<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				int value = map.get(i) + 1;
				map.put(i, value);
				max = Math.max(value, elsemax);
			} else {
				map.put(i, 1);
			}
		}
		List<Integer>[] bucketList = new ArrayList[max + 1];

		for (int i = 0; i <= max; i++) {
			bucketList[i] = new ArrayList<>();
		}
		for (Integer key : map.keySet()) {

			int freq = map.get(key);

			bucketList[freq].add(key);

		}

		int count = 0;
		for (int i = bucketList.length - 1; i >= 0; i--) {
			List<Integer> a = bucketList[i];
			for (int x : a) {
				if (count < k) {
					list.add(x);
					count++;
				} else {
					return list;
				}
			}

		}
		return list;
	}

}
*/
