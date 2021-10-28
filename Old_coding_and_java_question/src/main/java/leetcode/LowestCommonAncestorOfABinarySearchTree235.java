package leetcode;

public class LowestCommonAncestorOfABinarySearchTree235 {
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		int max = Math.max(p.val, q.val);
		int min = Math.min(p.val, q.val);

		if (max == root.val || min == root.val)
			return root;
		if (max > root.val && root.val > min)
			return root;
		if (root.val > max)
			return lowestCommonAncestor(root.left, p, q);
		return lowestCommonAncestor(root.right, p, q);

	}

	static TreeNode root;

	public static void main(String args[]) {
		LowestCommonAncestorOfABinarySearchTree235 m = new LowestCommonAncestorOfABinarySearchTree235();
		m.root = new TreeNode(6);
		m.root.left = new TreeNode(2);
		m.root.left.left = new TreeNode(0);
		m.root.left.right = new TreeNode(4);
		m.root.left.right.left = new TreeNode(3);
		m.root.left.right.right = new TreeNode(5);
		m.root.right = new TreeNode(8);
		m.root.right.left = new TreeNode(7);
		m.root.right.right = new TreeNode(9);
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(3);

		System.out.println(lowestCommonAncestor(root, p, q).val);
	}

}
