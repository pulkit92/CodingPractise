package leetcode.array;

public class TwoSumIIInputArrayIsSorted167 {
	public static void main(String args[]) {
		int[] nums = { 2,7,11,15};
		int a[] = twoSum(nums, 9);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] numbers, int target) {
		int i = 0;
		int a[] = new int[2];
		int j = numbers.length - 1;
		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				a[0] = i;
				a[1] = j;
				break;
			} else if (sum > target) {
				j--;
			} else {
				i++;
			}

		}
		return a;
	}
}
