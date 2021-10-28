package leetcode.array;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 1 };
		int a = maxProfit(arr);

		System.out.println(a);
	}

	public static int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int profit = 0;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				max = prices[i];

			}
			if (prices[i] > max) {
				max = prices[i];
			}
			profit = Math.abs(min - max);
			if (profit > maxprofit) {
				maxprofit = profit;
			}
		}
		return maxprofit;
	}

}
