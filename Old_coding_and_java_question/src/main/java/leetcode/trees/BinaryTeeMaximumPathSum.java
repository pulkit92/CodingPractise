package leetcode.trees;

public class BinaryTeeMaximumPathSum {
	static int max = Integer.MIN_VALUE;
	static int sum = 0;

	public static int maxPathSum(TreeNode root) {
		maxPathSum1(root);
		return max;
	}

	public static void maxPathSum1(TreeNode root) {
		if (root != null) {
				
			maxPathSum1(root.left);
			sum = Math.max(sum + root.val, root.val);
			max = Math.max(sum, max);
			maxPathSum1(root.right);
		}
	}

	static TreeNode root;

	public static void main(String args[]) {
		BinaryTeeMaximumPathSum m = new BinaryTeeMaximumPathSum();
		m.root = new TreeNode(-10);
		m.root.left = new TreeNode(9);

		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.right = new TreeNode(7);



		System.out.println(maxPathSum(root));
	}
}
