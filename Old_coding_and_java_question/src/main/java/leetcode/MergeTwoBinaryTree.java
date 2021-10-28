package leetcode;

public class MergeTwoBinaryTree {
	static TreeNode t1, t2;

	public static void main(String args[]) {
		MergeTwoBinaryTree m = new MergeTwoBinaryTree();
		m.t1 = new TreeNode(1);
		m.t1.left = new TreeNode(3);
		m.t1.right = new TreeNode(2);
		m.t1.left.left = new TreeNode(5);

		m.t2 = new TreeNode(2);
		m.t2.left = new TreeNode(1);
		m.t2.right = new TreeNode(3);
		m.t2.left.right = new TreeNode(4);
		m.t2.right.right = new TreeNode(7);
		TreeNode n = mergeTrees(t1, t2);
		printTree(n);

	}

	public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		int data = 0;
		if (t1 != null) {
			data = data + t1.val;

		}
		if (t2 != null) {
			data = data + t2.val;

		}
		TreeNode temp = new TreeNode(data);
		temp.left = mergeTrees(t1 != null ? t1.left : null, t2 != null ? t2.left : null);
		temp.right = mergeTrees(t1 != null ? t1.right : null, t2 != null ? t2.right : null);
		return temp;

	}

	static void printTree(TreeNode m) {
		if (m == null)
			return;
		System.out.println(m.val);
		printTree(m.left);
		printTree(m.right);

	}
}
