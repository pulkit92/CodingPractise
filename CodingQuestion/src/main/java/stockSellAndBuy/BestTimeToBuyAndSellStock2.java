/*
import java.util.List;
import java.util.Queue;

public class BestTimeToBuyAndSellStock2 {
  public int maxProfit(int[] prices) {
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
      if  (max - min > out) {
        out = (max - min);
        min=0;
        sum = sum + out;
      }
      k++;
    }
    return sum;
  }

  public static void main(String args[]) {
    BestTimeToBuyAndSellStock2 b = new BestTimeToBuyAndSellStock2();
    int prices[] = {7, 1, 5, 3, 6, 4};
    System.out.println(b.maxProfit(prices));
    TreeNode root=null;
    List<List<Integer>> res = new LinkedList<>();
    if(root == null)  ;

    Queue<TreeNode> q = new LinkedList<>();

    q.offer(root);
    while(!q.isEmpty()) {
      int size = q.size();LinkedList
      LinkedList<Integer> list = new LinkedList<>();
      for(int i=0;i<size;i++) {
        TreeNode n = q.poll();
        list.add(n.val);
        if(n.left!=null)
          q.offer(n.left);
        if(n.right!=null)
          q.offer(n.right);
      }
      ((LinkedList)res).addFirst(list);
    }

    return res;
  }

}
*/
