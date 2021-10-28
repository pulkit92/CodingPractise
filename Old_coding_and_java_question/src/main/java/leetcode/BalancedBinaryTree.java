package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalancedBinaryTree {
	static TreeNode root;

	public static void main(String args[]) {
		BalancedBinaryTree m = new BalancedBinaryTree();
		m.root = new TreeNode(1);
		m.root.right= new TreeNode(2);
		m.root.left = new TreeNode(2);
		m.root.left.right = new TreeNode(3);
		m.root.left.left	 = new TreeNode(3);
		m.root.left.left.left	 = new TreeNode(4);
		m.root.left.left.right	 = new TreeNode(4);
		System.out.println(isBalanced(root));

	}

	public static boolean isBalanced(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		getheight(root, 0, list);
		if (list.contains(2) || list.contains(3) || list.contains(4) || list.contains(5) || list.contains(6)
				|| list.contains(7) || list.contains(8) || list.contains(9)) {
			return false;
		}
		return true;

	}

	static int getheight(TreeNode root, int h, List<Integer> list) {
		if (root == null)
			return h;
		int l = getheight(root.left, h + 1, list);
		int r = getheight(root.right, h + 1, list);
		list.add(Math.abs(l - r));
		if (l > r)
			return l;
		return r;

	}

}
