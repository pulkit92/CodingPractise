package leetcode;

public class MaxDepthOfTree {
	static TreeNode root;

	public static void main(String args[]) {
		MaxDepthOfTree m = new MaxDepthOfTree();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(9);
		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.left = new TreeNode(7);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode root) {
		return maxDepth1(root, 0);
	}

	public static int maxDepth1(TreeNode node, int h) {
		if (node == null)
			return h;
		int l = maxDepth1(node.left, h + 1);
		int r = maxDepth1(node.right, h + 1);
		if (l > r)
			return l;
		return r;
	}
}
