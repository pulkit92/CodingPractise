package test;

public class Leet11 {
	public static void main(String args[]) {
		Leet11 l = new Leet11();
		int a[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(l.maxArea(a));

	}

	public int maxArea(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int b = j - i;
				int l = Math.min(height[i], height[j]);
				area = Math.max(l * b, area);
			}
		}

		return area;
	}
}
