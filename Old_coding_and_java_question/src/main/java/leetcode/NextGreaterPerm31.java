package leetcode;

public class NextGreaterPerm31 {
	public static void main(String[] args) {
		int arr[] = {1,2,3};
		nextPermutation(arr);
		for(int i:arr)
		System.out.println((i));

	}

	public static void nextPermutation(int[] nums) {
		boolean b = false;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] >= nums[i + 1])
				b = true;
			else {
				b = false;
				break;
			}
		}
		if (b == true) {
			int i = nums.length - 1;
			int j = 0;
			while (i > j) {
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i--;
				j++;
			}
		}

	}
}
