package tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTreeGFG {
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> queue1 = new LinkedList<>();
    Queue<TreeNode> queue2 = new LinkedList<>();
    int max_width = 0;
    queue1.add(root);
    while (!queue1.isEmpty() || !queue2.isEmpty()) {
      int width = 0;
      while (!queue1.isEmpty()) {
        TreeNode node = queue1.poll();
        width++;
        if (node == null) {
          continue;

        }
        queue2.add(node.left);
        queue2.add(node.right);
      }
      if (width > max_width) {
        max_width = width;
      }
      width = 0;
      while (!queue2.isEmpty()) {
        TreeNode node = queue2.poll();
        width++;
        if (node == null) {
          continue;
        }
        queue1.add(node.left);
        queue1.add(node.right);
      }
      if (width > max_width) {
        max_width = width;
      }
    }

    return max_width;
  }

  public static void main(String args[]) {
    MaximumWidthOfBinaryTreeGFG maximumWidthOfBinaryTree=new MaximumWidthOfBinaryTreeGFG();
    TreeNode node=new TreeNode( 1);
    node.left=new TreeNode(3);
    node.left.left=new TreeNode(5);
    node.left.right=new TreeNode(3);
    node.right=new TreeNode(2);
    node.right.right= new TreeNode(9);
    maximumWidthOfBinaryTree.widthOfBinaryTree(node);

  }
}
