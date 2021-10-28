package leetcode;

public class MininmumDepthOfBinaryTree {
	static TreeNode root;

	public static void main(String args[]) {
		MininmumDepthOfBinaryTree m = new MininmumDepthOfBinaryTree();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(9);
		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.left = new TreeNode(7);
		diameterOfBinaryTree(root);
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return 1;

		int min = Integer.MAX_VALUE;
		if (root.left != null) {
			min = Math.min(min, diameterOfBinaryTree(root.left));
		}
		if (root.right != null) {
			min = Math.min(min, diameterOfBinaryTree(root.right));
		}
		return 1+min;
	}
}
