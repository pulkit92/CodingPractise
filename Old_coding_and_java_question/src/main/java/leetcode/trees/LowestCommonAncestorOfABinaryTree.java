package leetcode.trees;/*
package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.MaxDepthOfTree;
import leetcode.trees.TreeNode;
import linkedlist.linkedList;

public class LowestCommonAncestorOfABinaryTree {
	static TreeNode root;
	static 	

	public static void main(String args[]) {
		LowestCommonAncestorOfABinaryTree m = new LowestCommonAncestorOfABinaryTree();
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
		System.out.println(lowestCommonAncestor(root, p, q).val);
	}

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		savedata(root, p, q);
		return curr;
	}

	public static boolean savedata(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return false;
		}

		int left = savedata(root.left, p, q) ? 1 : 0;
		int right = savedata(root.right, p, q) ? 1 : 0;

		int mid = (root.val == p.val || root.val == q.val) ? 1 : 0;

		if (left + right + mid >= 2)
			curr = root;

		return (right + left + mid >= 0);

	}
}
*/
