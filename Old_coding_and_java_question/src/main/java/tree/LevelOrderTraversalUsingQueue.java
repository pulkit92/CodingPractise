package tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversalUsingQueue {
	static TreeNode root;

	public static void main(String args[]) {
		LevelOrderTraversalUsingQueue tree = new LevelOrderTraversalUsingQueue();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
				 printLevelOrder() ;
		System.out.println("Level order traversal of binary tree is ");
	}

	static void printLevelOrder() {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/*
			 * poll() removes the present head. For more information on poll() visit
			 * http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
			 */
			TreeNode tempNode = queue.poll();
			System.out.print(tempNode.data + " ");

			/* Enqueue left child */
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			/* Enqueue right child */
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
		}
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int item) {
		data = item;
		left = right = null;
	}
}
