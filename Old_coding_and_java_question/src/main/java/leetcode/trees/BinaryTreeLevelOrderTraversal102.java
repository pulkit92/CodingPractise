package leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
	static leetcode.trees.TreeNode root;

	public static void main(String args[]) {
		BinaryTreeLevelOrderTraversal102 m = new BinaryTreeLevelOrderTraversal102();
		m.root = new TreeNode(-10);
		m.root.left = new TreeNode(9);

		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.right = new TreeNode(7);

		System.out.println(levelOrder(root));
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		if (root == null)
			return list;

		q1.add(root);
		while (!q1.isEmpty() || !q2.isEmpty()) {
			List<Integer> list1 = new ArrayList<>();
			while (!q1.isEmpty()) {

				TreeNode p = q1.poll();
				list1.add(p.val);
				if (p.left != null)
					q2.add(p.left);
				if (p.right != null)
					q2.add(p.right);

			}
			list.add(list1);
			List<Integer> list2 = new ArrayList<>();
			while (!q2.isEmpty()) {
				TreeNode p = q2.poll();
				if (p.left != null)
					q1.add(p.left);
				if (p.right != null)
					q1.add(p.right);

			}
			list.add(list2);

		}
		return list;

	}
}
