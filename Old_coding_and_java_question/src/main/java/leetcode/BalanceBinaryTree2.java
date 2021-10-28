package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinaryTree2 {
	static TreeNode root;

	public static void main(String args[]) {
		BalancedBinaryTree m = new BalancedBinaryTree();
		m.root = new TreeNode(1);
		m.root.right = new TreeNode(2);
		m.root.left = new TreeNode(2);
		m.root.left.right = new TreeNode(3);
		m.root.left.left = new TreeNode(3);
		m.root.left.left.left = new TreeNode(4);
		m.root.left.left.right = new TreeNode(4);
		System.out.println(isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int l = getheight(root.left);
		int r = getheight(root.right);
		int abs = Math.min(l, r);
		if ((abs == 0 || abs == 1) && isBalanced(root.left) && isBalanced(root.right))
			return true;
		return false;
	}

	static int getheight(TreeNode root) {
		if (root == null)
			return 0;

		return (1 + Math.max(getheight(root.left), getheight(root.right)));

	}
}
