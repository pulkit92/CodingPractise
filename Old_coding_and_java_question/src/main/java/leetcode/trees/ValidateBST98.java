package leetcode.trees;

public class ValidateBST98 {
	private static TreeNode root;

	public static void main(String args[]) {
		ValidateBST98 m = new ValidateBST98();
		m.root = new TreeNode(-2147483648);
		m.root.left = new TreeNode(-2147483648);
	/*	m.root.right = new TreeNode(4);
		m.root.right.left = new TreeNode(3);
		m.root.right.right = new TreeNode(6);*/
		System.out.println(isValidBST(root));
	}

	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public static boolean isValidBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		if (root.val < min || root.val > max)
			return false;

		return (isValidBST(root.left, min, root.val - 1) && isValidBST(root.right, root.val + 1, max));
	}
}
