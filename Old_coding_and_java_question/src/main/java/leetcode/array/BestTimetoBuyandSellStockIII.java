package leetcode.array;

public class BestTimetoBuyandSellStockIII {
	public static int maxProfit(int[] prices) {
		int i = 0;
		int l = prices.length;
		int totalprofit = 0;
		int t1 = 0;
		while (i < l - 1) {
			while (i < l - 1 && prices[i] >= prices[i + 1])
				i++;
			int t = prices[i];
			while (i < l - 1 && prices[i] <= prices[i + 1])
				i++;
			if (prices[i] - t > totalprofit) {
				t1 = totalprofit;
				totalprofit = prices[i] - t;
			} else if (prices[i] - t > t1) {
				t1 = prices[i] - t;
			}

		}

		return totalprofit + t1;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0 };
		int a = maxProfit(arr);

		System.out.println(a);
	}

}
