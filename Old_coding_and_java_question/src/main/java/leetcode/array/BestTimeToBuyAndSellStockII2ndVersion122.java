package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockII2ndVersion122 {
	public static void main(String[] args) {
		int arr[] = {3,3,5,0,0,3,1,4 };
		int a = maxProfit(arr);

		System.out.println(a);
	}

	public static int maxProfit(int[] prices) {
		int i = 0;
		int l = prices.length;
		int totalprofit = 0;
		while (i < l - 1) {
			while (i < l - 1 && prices[i] <= prices[i + 1]) {
				totalprofit = totalprofit + (prices[i + 1] - prices[i]);
				i++;
			}
			i++;
		}

		return totalprofit;
	}

}
