package leetcode.array;

public class BestTimeToBuyAndSellStock2 {
	public static void main(String[] args) {
		int arr[] = { 2, 4, 1 };
		int a = maxProfit(arr);

		System.out.println(a);
	}

	public static int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int maxprofit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];

			} else if (prices[i] - min > maxprofit) {
				maxprofit = prices[i] - min;
			}
		}
		return maxprofit;
	}
}
