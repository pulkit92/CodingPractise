package leetcode;

public class SumofLeftLeaves {
	static TreeNode root;
	static int sum = 0;

	public static int sumOfLeftLeaves(TreeNode root) {
		return getSum(root);
	}

	public static int getSum(TreeNode root) {
		if (root == null) {

			return sum;
		}

		if (root.left != null) {
			sum = sum + root.left.val;
			getSum(root.left);
		}

		if (root.right != null) {
			getSum(root.right);
		}
		return sum;
	}

	public static void main(String args[]) {
		SumofLeftLeaves m = new SumofLeftLeaves();
		m.root = new TreeNode(3);
		m.root.left = new TreeNode(9);
		m.root.right = new TreeNode(20);
		m.root.right.left = new TreeNode(15);
		m.root.right.right = new TreeNode(7);
		System.out.println(sumOfLeftLeaves(root));
	}
}
