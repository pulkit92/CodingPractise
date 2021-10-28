package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
	static TreeNode root;

	public static void main(String args[]) {
		BinaryTreeInorderTraversal94 m = new BinaryTreeInorderTraversal94();
		m.root = new TreeNode(1);

		m.root.right = new TreeNode(2);
		m.root.right.left = new TreeNode(3);

		System.out.println(inorderTraversal(root));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		return inorderTraversal(root, list);

	}

	public static List<Integer> inorderTraversal(TreeNode root, List<Integer> list) {
		if (root != null) {

			inorderTraversal(root.left, list);
			list.add(new Integer(root.val));
			inorderTraversal(root.right, list);
		}
		return list;

	}
}
