package stockSellAndBuy;

public class BestTimeToBuyAndSellStock121 {
/*  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int min = prices[0];
    int max = 0;
    int k = 1;
    int out = 0;
    int sum = 0;
    while (k < prices.length) {
      if (min > prices[k]) {
        min = prices[k];
        max = 0;
      }
      if (prices[k] > min) {
        max = prices[k];
      }
      out = out + Integer.max(out, max - min);
      k++;
    }
    return out;
  }*/


  public static void main(String args[]) {
    BestTimeToBuyAndSellStock121 b = new BestTimeToBuyAndSellStock121();
    int prices[] = {7, 1, 5, 3, 6, 4};
  //  System.out.println(b.maxProfit(prices));
  }
}
