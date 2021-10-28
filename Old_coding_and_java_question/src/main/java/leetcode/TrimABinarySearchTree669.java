package leetcode;

public class TrimABinarySearchTree669 {
	static TreeNode root;

	public static TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		if (root.val >= L && R >= root.val) {
			TreeNode temp = new TreeNode(root.val);
			temp.left = trimBST(root.left, L, R);
			temp.right = trimBST(root.right, L, R);
			return temp;
		}
		if (L > root.val)
			return trimBST(root.right, L, R);
		return trimBST(root.left, L, R);

	}

	public static void main(String args[]) {
		TrimABinarySearchTree669 m = new TrimABinarySearchTree669();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(0);
		m.root.left.right = new TreeNode(2);
		m.root.left.right.left = new TreeNode(1);
		m.root.right = new TreeNode(4);

		trimBST(root, 1, 3);
	}
}
