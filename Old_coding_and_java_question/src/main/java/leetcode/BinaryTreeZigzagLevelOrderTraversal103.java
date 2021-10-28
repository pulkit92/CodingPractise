package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import leetcode.BinaryTreeZigzagLevelOrderTraversal103.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal103 {
	static TreeNode root;

	static class TreeNode {
		TreeNode left, right;
		int data;

		TreeNode(int data) {
			this.data = data;
		}
	}

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the nodes
		 */
		BinaryTreeZigzagLevelOrderTraversal103 tree_level = new BinaryTreeZigzagLevelOrderTraversal103();

		tree_level.root = new TreeNode(3);
		tree_level.root.left = new TreeNode(9);
		tree_level.root.right = new TreeNode(20);
		tree_level.root.right.left = new TreeNode(15);
		tree_level.root.right.right = new TreeNode(7);

		List<List<Integer>> re = zigzagLevelOrder(root);
		System.out.println("Level order traversal of binary tree is - " + re);
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> re = new ArrayList<>();
		if (root == null)
			return re;

		Stack<TreeNode> st1 = new Stack<TreeNode>();
		Stack<TreeNode> st2 = new Stack<TreeNode>();
		st1.push(root);
		while ((!st1.isEmpty()) || (!st2.isEmpty())) {
			List<Integer> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();
			while (!st1.isEmpty()) {
				TreeNode tem = st1.pop();
				list1.add(tem.data);

				if (tem.right != null) {
					st2.push(tem.right);
				}
				if (tem.left != null) {
					st2.push(tem.left);
				}
			}
			while (!st2.isEmpty()) {
				TreeNode tem = st2.pop();
				list2.add(tem.data);

				if (tem.left != null) {
					st1.push(tem.left);
				}
				if (tem.right != null) {
					st1.push(tem.right);
				}
			}
			if(!list1.isEmpty())
				re.add(list1);
			if (!list2.isEmpty())
				re.add(list2);

		}
		return re;
	}
}
