package leetcode.array;

public class Segregate0sand1sand2s {
	public static void main(String[] args) {
		int arr[] = { 2, 1, 2, 0, 2, 0,2 };
		int a[] = segregate(arr);
		for (int i : a)
			System.out.println(i);
	}

	public static int[] segregate(int a[]) {

		int l = 0;
		int r = a.length - 1;
		int mid = 0;
		
		while (mid < r) {
			if (a[mid] == 2) {
				while (a[r] == 2)
					r--;
				int temp = a[r];
				a[r] = a[mid];
				a[mid] = temp;
				r--;
				mid++;
			} else if (a[mid] == 0) {
				while (a[l] == 0)
					l++;
				int temp = a[l];
				a[l] = a[mid];
				a[mid] = temp;
				l++;
				mid++;
			} else {
				mid++;
			}

		}
		return a;

	}
}
