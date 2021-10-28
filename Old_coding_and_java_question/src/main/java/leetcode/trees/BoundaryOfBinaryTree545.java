package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryOfBinaryTree545 {
	static TreeNode root;
	static int max;

	public static void main(String args[]) {
		BoundaryOfBinaryTree545 m = new BoundaryOfBinaryTree545();
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
		System.out.println(boundaryOfBinaryTree(root));
	}

	public static List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> list = new ArrayList<>();

		if (root != null) {
			list.add(root.val);
			getleft(root.left, list);
			getleaves(root.left, list);
			getleaves(root.right, list);
			getRight(root.right, list);
		}
		return list;

	}

	private static void getRight(TreeNode root2, List<Integer> list) {
		if (root2 != null) {
			if (root2.right != null) {
				getleft(root2.right, list);
				list.add(root2.val);

			} else if (root2.left != null) {
				getleft(root2.left, list);
				list.add(root2.val);

			}
		}

	}

	private static void getleaves(TreeNode root2, List<Integer> list) {
		if (root2 != null) {
			getleaves(root2.left, list);
			if (root2.left == null && root2.right == null) {
				list.add(root2.val);
			}
			getleaves(root2.right, list);

		}

	}

	private static void getleft(TreeNode root2, List<Integer> list) {
		if (root2 != null) {
			if (root2.left != null) {
				getleft(root2.left, list);
				list.add(root2.val);

			} else if (root2.right != null) {
				getleft(root2.right, list);
				list.add(root2.val);

			}
		}

	}
}
