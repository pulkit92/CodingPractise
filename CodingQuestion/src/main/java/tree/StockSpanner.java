package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StockSpanner {
  Stack<Integer> prices, weights;

  public StockSpanner() {
    prices = new Stack();
    weights = new Stack();
  }

  public int next(int price) {
    Queue<TreeNode> queue=new LinkedList<>();
    int w = 1;
    while (!prices.isEmpty() && prices.peek() < price) {
      w = w + weights.pop();
      prices.pop();
    }
    prices.add(price);
    weights.add(w);
    return w;

  }

  public static void main(String args[]) {
    StockSpanner stockSpanner = new StockSpanner();
    stockSpanner.next(100);
    stockSpanner.next(80);

    stockSpanner.next(60);
    stockSpanner.next(70);

    stockSpanner.next(60);
    stockSpanner.next(75);
    stockSpanner.next(85);


  }
}
