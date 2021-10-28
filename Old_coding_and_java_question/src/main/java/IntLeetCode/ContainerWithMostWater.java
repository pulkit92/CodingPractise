package IntLeetCode;

import java.util.Arrays;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int a = 0;
		int b = height.length - 1;
		int max = Integer.MIN_VALUE;
		while (a < b) {
			max = Math.max(((b - a) * Math.min(height[a], height[b])), max);
			if (height[a] < height[b]) {
				a++;
			} else
				b--;
		}
		return max;

	}

	public static void main(String args[]) {
		int a[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(a));
	}
}
