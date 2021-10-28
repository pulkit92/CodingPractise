package leetcode.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	static List<Integer> list = new ArrayList<>();

	static int minCoins(int coins[], int m, int V, List<Integer> list1) {
		// base case
		if (V == 0)
			return 0;

		// Initialize result
		int res = Integer.MAX_VALUE;

		// Try every coin that has smaller value than V
		for (int i = 0; i < m; i++) {
			if (coins[i] <= V) {
				list1.add(coins[i]);
				int sub_res = minCoins(coins, m, V - coins[i], list1);

				// Check for INT_MAX to avoid overflow and see if
				// result can minimized
				if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
					res = sub_res + 1;
					list.add(coins[i]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int coins[] = { 1, 2, 5 };
		System.out.println(minCoins(coins, coins.length, 11, new ArrayList<>()));
		System.out.println(list);

	}

}