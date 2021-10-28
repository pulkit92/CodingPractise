package leetcode;

public class ConvertSortedArrayToBinarySearchTree108 {
	static TreeNode root;

	public static void main(String args[]) {
		int[] nums = { -10, -3, 0, 5, 9 };
		System.out.println(sortedArrayToBST(nums));
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBST(nums, 0, nums.length - 1);
	}

	public static TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int middle = (start + end) / 2;
		TreeNode node = new TreeNode(nums[middle]);
		node.left = sortedArrayToBST(nums, start, middle - 1);
		node.right = sortedArrayToBST(nums, middle + 1, end);
		return node;

	}
}
