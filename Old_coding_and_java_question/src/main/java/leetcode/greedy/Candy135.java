package leetcode.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Candy135 {
	static Map<Integer, Integer> map = new HashMap<>();

	public static int candy(int[] ratings) {

		int left[] = new int[ratings.length];
		Arrays.fill(left, 1);
		int right[] = new int[ratings.length];
		Arrays.fill(right, 1);

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i - 1] < ratings[i])
				left[i] = left[i - 1] + 1;
		}
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i + 1] < ratings[i])
				right[i] = right[i + 1] + 1;
		}

		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum = sum + Math.max(right[i], left[i]);
		}

		return sum;
	}
	
}
