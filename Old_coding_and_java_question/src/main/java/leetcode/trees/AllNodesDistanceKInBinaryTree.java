package leetcode.trees;/*
package leetcode.trees;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {
	static TreeNode root;
	static Set<TreeNode> listNode = new HashSet<>();

	public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		//List<Integer> list = new ArrayList<>();

		TreeNode a = findnode(root, target);

		List<Integer> list1 = moveforward(a, K, list);
		list.addAll(list1);
		for (TreeNode t : listNode) {
			moveback(TreeNode root, TreeNode a, int d)
		}

		return list;
	}

	public static List<Integer> moveforward(TreeNode root, int d, List<Integer> list) {
		if (d == 0) {
			if (root != null)
				list.add(new Integer(root.val));

		}
		if (d > 0) {
			if (root != null) {
				moveforward(root.left, d - 1, list);
				moveforward(root.right, d - 1, list);

			}

		}
		return list;
	}

	public static void moveback(TreeNode root, TreeNode a, int d) {
		int h = findnode1(root, a, 0);
		int x = d - h;
		moveback1(root, a, x);

	}

	public static void moveback1(TreeNode root, TreeNode a, int d) {
		if (root == null)
			return;
		if (d == 0)
			listNode.add(root);

		moveback1(root.left, a, d - 1);
		moveback1(root.right, a, d - 1);

	}

	public static int findnode1(TreeNode root, TreeNode target, int h) {
		if (root == null)
			return 0;

		if (root.val == target.val)
			return h;

		int a = findnode1(root.left, target, h + 1);
		if (a != 0)
			return a;
		return findnode1(root.right, target, h + 1);

	}

	public static TreeNode findnode(TreeNode root, TreeNode target) {
		if (root == null)
			return null;

		if (root.val == target.val)
			return root;

		listNode.add(root);

		TreeNode a = findnode(root.left, target);
		if (a != null)
			return a;
		return findnode(root.right, target);

	}

	public static void main(String args[]) {
		AllNodesDistanceKInBinaryTree m = new AllNodesDistanceKInBinaryTree();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(5);
		m.root.left.left = new TreeNode(6);
		m.root.left.right = new TreeNode(2);
		m.root.left.right.left = new TreeNode(7);
		m.root.left.right.right = new TreeNode(4);
		m.root.right = new TreeNode(1);
		m.root.right.left = new TreeNode(0);
		m.root.right.right = new TreeNode(8);
		System.out.println(distanceK(root, new TreeNode(5), 2));
	}
}
*/
