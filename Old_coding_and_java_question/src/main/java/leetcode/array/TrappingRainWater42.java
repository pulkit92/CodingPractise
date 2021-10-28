package leetcode.array;

public class TrappingRainWater42 {
	public static int trap(int[] height) {
		int sum = 0;
		int left = Integer.MIN_VALUE;
		int right[] = lookright(height);

		for (int i = 0; i < height.length ; i++) {
			int rights = right[i];
			int value = height[i];
			if ((left != 0 && left != Integer.MIN_VALUE) && (rights != 0 && rights != Integer.MIN_VALUE)) {
				sum = sum + Math.max((Math.min(left, rights) - value), 0);
			}
			left = Math.max(left, value);
 
		}
		return sum;
	}

	public static int[] lookright(int a[]) {
		int b[] = new int[a.length];
		int max = Integer.MIN_VALUE;
		for (int j = a.length - 1; j >= 0; j--) {
			b[j] = max;
			max = Math.max(a[j], max);

		}
		return b;
	}

	public static void main(String args[]) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}
}
