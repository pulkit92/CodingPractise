package leetcode;

public class InvertBinaryTree226 {
	static TreeNode root;

	public static void main(String args[]) {
		MaxDepthOfTree m = new MaxDepthOfTree();
		m.root = new TreeNode(4);
		m.root.left = new TreeNode(2);
		m.root.right = new TreeNode(7);
		m.root.right.left = new TreeNode(6);
		m.root.right.right = new TreeNode(9);
		m.root.left.left = new TreeNode(1);
		m.root.left.right = new TreeNode(3);
		System.out.println(invertTree(root));
	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	/*
	 * public static TreeNode invertTree1(TreeNode left,TreeNode right) { if (root
	 * == null) return root; }
	 */
}
