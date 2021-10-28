package leetcode.array;

public class Segregate0sand1s {
	public static void main(String[] args) {
		int arr[] = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
		int a[] = segregate(arr);
		for (int i : a)
			System.out.println(i);
	}

	public static int[] segregate(int a[]) {

		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		return a;

	}
}
