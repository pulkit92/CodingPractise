package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class BestTimeToBuyAndSellStockII122 {

	public static void main(String[] args) {
		int arr[] = {3,3};
		int a = maxProfit(arr);

		System.out.println(a);
	}

	public static int maxProfit(int[] prices) {
		List<MaxProfit> list = new ArrayList<MaxProfit>();
		int i = 0;
		int l = prices.length;
		while (i < l-1) {
			MaxProfit m = new MaxProfit();
			while (i < l-1 && prices[i] >= prices[i + 1]) {
				i++;
			}
			m.setX(prices[i]);
			while (i < l-1 && prices[i] <= prices[i + 1]) {
				i++;
			}
			m.setY(prices[i]);
			list.add(m);
		}
		int totalprofit = 0;
		for (MaxProfit m : list) {
			totalprofit = totalprofit + m.getY() - m.getX();
		}
		if (totalprofit <= 0)
			return 0;

		return totalprofit;
	}
}

class MaxProfit {
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	private int x;
	private int y;
}
