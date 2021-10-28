package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.BinaryTreeZigzagLevelOrderTraversal103.TreeNode;

public class SameTree100 {
	static TreeNode p, q;

	static class TreeNode {
		TreeNode left, right;
		int val;

		TreeNode(int val) {
			this.val = val;
		}
	}

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the nodes
		 */
		SameTree100 tree_level = new SameTree100();

		tree_level.p = new TreeNode(1);
		tree_level.p.left = new TreeNode(2);
		// tree_level.p.right = new TreeNode(3);

		tree_level.q = new TreeNode(1);
		tree_level.q.right = new TreeNode(2);

		System.out.println("Level order traversal of binary tree is - " + isSameTree(p, q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
			return true;
		}
		return false;

	}
}
