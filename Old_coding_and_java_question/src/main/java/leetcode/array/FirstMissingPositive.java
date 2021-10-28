package leetcode.array;

public class FirstMissingPositive {
	public static void main(String args[]) {
		int[] a = {1,2,0};

		System.out.println(firstMissingPositive(a));

	}

	public static int firstMissingPositive(int[] nums) {
			int j = modify(nums);
		
			for (int i = 0; i < j; i++) {
				int val = Math.abs(nums[i]) - 1;
				if (val >= 0 && val < j && nums[val] > 0) {
					nums[val] = -nums[val];
	
				}
			}
			for (int i = 0; i < j; i++) {
				if (nums[i] > 0) {
					return i + 1;
				}
			}
			return j+1;

	}

	private static int modify(int a[]) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] >= 0) {
				int tem = a[i];
				a[i] = a[j];
				a[j] = tem;
				j++;
			}
		}
		return j;

	}
}
