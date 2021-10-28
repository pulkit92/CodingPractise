package tree;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinarySearchTree98Iterative {
  static TreeNode root;

  public static void main(String[] args) {
    ValidateBinarySearchTree98 i = new ValidateBinarySearchTree98();
    i.root = new TreeNode(1);
    i.root.right = new TreeNode(2);
    i.root.right.left = new TreeNode(3);
    System.out.println(i.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {

    if (root == null) {
      return true;
    }

    Queue<TreeNode> rootStack = new LinkedList<>();
    Queue<Integer> left = new LinkedList<>();
    Queue<Integer> right = new LinkedList<>();
    rootStack.add(root);
    while (!rootStack.isEmpty()) {
      TreeNode temp = rootStack.poll();
      Integer rightNode = right.poll();
      Integer leftNode = left.poll();
      if (root == null) {
        continue;
      }
      int val = temp.val;
      if (rightNode != null && val >= rightNode) {
        return false;
      }
      if (leftNode != null && val <= leftNode) {
        return false;
      }
      rootStack.add(temp.right);


    }
    return true;


  }

}
