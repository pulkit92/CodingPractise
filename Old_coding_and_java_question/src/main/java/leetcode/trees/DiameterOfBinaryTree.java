package leetcode.trees;

public class DiameterOfBinaryTree {
	int ans;

	public int diameterOfBinaryTree(TreeNode root) {
		ans = 1;
		FinddiameterOfBinaryTree(root);
		return ans - 1;
	}

	public int FinddiameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;

		int l = FinddiameterOfBinaryTree(root.left);
		int r = FinddiameterOfBinaryTree(root.right);

		ans = Math.max(ans, (l + r + 1));
		return Math.max(l, r) + 1;
	}

}
