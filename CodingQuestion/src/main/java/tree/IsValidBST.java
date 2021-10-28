package tree;

import java.util.Stack;

public class IsValidBST {
  public boolean isValidBST(TreeNode root) {
    Stack<BST> stack = new Stack<>();
    if (root == null) {
      return true;
    }
    stack.add(new BST(root, null, null));
    while (!stack.empty()) {
      BST bst = stack.pop();

      if (bst.node == null) {
        continue;
      }
      if (bst.lower != null && bst.lower >= bst.node.val) {
        return false;
      }
      if (bst.upper != null && bst.upper <= bst.node.val) {
        return false;
      }
      stack.add(new BST(bst.node.right, bst.node.val, bst.upper));
      stack.add(new BST(bst.node.left, bst.lower, bst.node.val));

    }
    return true;

  }


  public static void main(String args[]) {
    TreeNode treeNode = new TreeNode(2);
    treeNode.left = new TreeNode(1);
    treeNode.right = new TreeNode(3);
    IsValidBST isValidBST = new IsValidBST();
    isValidBST.isValidBST(treeNode);
  }
}


class BST {
  TreeNode node;
  Integer lower;
  Integer upper;

  public BST(TreeNode node, Integer lower, Integer upper) {
    this.node = node;
    this.lower = lower;
    this.upper = upper;
  }
}
