package leetcode.array;

public class Sortarraybyparityii {
	public static int[] sortArrayByParityII(int[] A) {
		int i = 0;
		int j = 1;
		while (i < A.length && j < A.length) {
			while (i < A.length && A[i] % 2 == 0)
				i = i + 2;
			while (j < A.length && A[j] % 2 != 0)
				j = j + 2;

			if (i < A.length && j < A.length) {
				int t = A[j];
				A[j] = A[i];
				A[i] = t;
				j = j + 2;
				i = i + 2;
			}
		}
		return A;
	}

	public static void main(String[] args) {
		int arr[] = { 2, 1, 0, 1, 1, 2, 0, 3 };
		int a[] = sortArrayByParityII(arr);
		for (int i : a)
			System.out.println(i);
	}
}
