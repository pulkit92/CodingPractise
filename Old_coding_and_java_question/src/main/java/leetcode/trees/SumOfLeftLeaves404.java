package leetcode.trees;

public class SumOfLeftLeaves404 {
	static int sum = 0;
	static int max = 0;
	static TreeNode root;

	public static void main(String args[]) {
		SumOfLeftLeaves404 m = new SumOfLeftLeaves404();
		m.root = new TreeNode(1);
		//m.root.left = new TreeNode(9);

		m.root.right = new TreeNode(2);
		//m.root.right.left = new TreeNode(15);
		//m.root.right.right = new TreeNode(7);
		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(1);
		System.out.println(sumOfLeftLeaves(root));
	}

	public static int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		
		if(root.left==null)
			sum=sum+root.val;
		sumOfLeftLeaves(root, 1);
		return sum-root.val;
	}

	public static int sumOfLeftLeaves(TreeNode root, int level) {

		if (root == null)
			return 0;
		if (level > max) {
			sum = sum + root.val;
			max = level;

		}
		sumOfLeftLeaves(root.left, level + 1);
		sumOfLeftLeaves(root.right, level+1 );
		return sum;
	}
}
