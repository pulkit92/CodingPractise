package leetcode;

public class SymmetricTree {
	static TreeNode root;

	public static void main(String args[]) {
		SymmetricTree m = new SymmetricTree();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(9);
		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.left = new TreeNode(7);
		isSymmetric(root);
	}

	public static boolean isSymmetric(TreeNode root) {
		return isSymmetricNode(root, root);
	}

	public static boolean isSymmetricNode(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left != null && right != null) {
			if (left.val == right.val && isSymmetricNode(left.left, right.left)
					&& isSymmetricNode(left.right, right.left)) {
				return true;
			}
		}
		return false;

	}
}
