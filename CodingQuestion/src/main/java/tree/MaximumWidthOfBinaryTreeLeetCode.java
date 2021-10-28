package tree;

import java.util.HashMap;
import java.util.Map;

public class MaximumWidthOfBinaryTreeLeetCode {

  public static void main(String args[]) {
    MaximumWidthOfBinaryTreeLeetCode maximumWidthOfBinaryTree = new MaximumWidthOfBinaryTreeLeetCode();
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(3);
    node.left.left = new TreeNode(5);
    node.left.right = new TreeNode(3);
    node.right = new TreeNode(2);
    node.right.right = new TreeNode(9);
    System.out.println(maximumWidthOfBinaryTree.widthOfBinaryTree(node));
  }
  Map<Integer, Integer> map = new HashMap<>();
  int max_width = 0;
  public int widthOfBinaryTree(TreeNode root) {
    widthOfBinaryTree(root, 0, 0);
    return max_width;
  }

  public void widthOfBinaryTree(TreeNode root, int postion, int depth) {
    if (root == null) {
      return;
    }
    map.putIfAbsent(depth, postion);
    max_width = Math.max(max_width, postion - map.get(depth) + 1);
    widthOfBinaryTree(root.left, postion * 2, depth + 1);
    widthOfBinaryTree(root.right, postion * 2 + 1, depth + 1);
  }
}

