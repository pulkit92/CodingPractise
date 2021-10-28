package leetcode.dp;

import java.util.Arrays;

public class CoinChange {
	static int count1 = Integer.MIN_VALUE;

	public static int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		coinChange(0, coins, amount);
		return count1;
	}

	public static void coinChange(int count, int[] coins, int amount) {
		if (amount == 0) {
			if (count1 == Integer.MIN_VALUE) {
				count1 = count;
			} else
				count1 = Math.min(count1, count);
		}
		if (amount > 0) {
			for (int i = coins.length-1; i>=0;i++) {
				coinChange(count + 1, coins, amount - coins[i]);

			}
		}

	}

	public static void main(String args[]) {
		int a[] = { 1, 2, 5 };
		int amt = 11;
		System.out.println(coinChange(a, amt));
	}
}
