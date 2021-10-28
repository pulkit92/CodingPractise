package leetcode.dp;

public class ClimbStairs {
	public static int climbStairs(int n) {
		if (n < 0)
			return 0;
		int a[] = new int[n + 1];
		return climbStairs(n, a);

	}

	public static int climbStairs(int n, int a[]) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (a[n] != 0)
			return a[n];

		return a[n] = climbStairs(n - 2,a) + climbStairs(n - 1,a);
	}

	public static void main(String[] args) {
		int list = climbStairs(4);
		System.out.println(list);

	}
}
