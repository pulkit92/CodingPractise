package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView199 {
	static TreeNode root;
	static int max;

	public static void main(String args[]) {
		BinaryTreeRightSideView199 m = new BinaryTreeRightSideView199();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(5);
		m.root.left.left = new TreeNode(6);
		m.root.left.right = new TreeNode(2);
		m.root.left.right.left = new TreeNode(7);
		m.root.left.right.right = new TreeNode(4);
		m.root.right = new TreeNode(1);
		m.root.right.left = new TreeNode(0);
		m.root.right.right = new TreeNode(8);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		System.out.println(rightSideView(root));
	}

	public static List<Integer> rightSideView(TreeNode root) {
		return rightSideView(new ArrayList<>(), root, 1);
	}

	public static List<Integer> rightSideView(List<Integer> list, TreeNode root, int level) {
		if (root != null) {
			if (level > max) {
				max = level;
				list.add(root.val);
			}
			rightSideView(list, root.right, level + 1);
			rightSideView(list, root.left, level + 1);
		}
		return list;
	}
}
