/*
package leetcode.dp;

public class MinCostClimbingStairs {
	public static int minCostClimbingStairs(int[] cost) {
		int a[] = new int[cost.length + 1];
		 a[0]=cost[0];
		 a[1]=cost[1];
		
		return minCostClimbingStairs(cost, a, 0,cost.length);

	}

	public static int minCostClimbingStairs(int cost[], int a[], int i,int n) {
		if (i > n)
			return 0;
		if (i == n)
			return ;

		if (a[n] != 0)
			return a[n];

		return a[n] = climbStairs(n - 2, a) + climbStairs(n - 1, a);
	}

	public static void main(String[] args) {
		int[] cost = { 10, 15, 20 };
		int list = minCostClimbingStairs(cost);
		System.out.println(list);

	}
}
*/
