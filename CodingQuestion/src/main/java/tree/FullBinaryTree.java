package tree;

public class FullBinaryTree {
  boolean isFullTree(TreeNode node) {
    if (node == null || (node.right == null && node.right == null)) {
      return true;
    }
    if (node.left != null && node.right != null) {
      if (!isFullTree(node.left)) {
        return false;
      }
      if (!isFullTree(node.right)) {
        return false;
      }

      return true;
    }
    return false;
  }

  public static void main(String args[]) {
    FullBinaryTree fullBinaryTree = new FullBinaryTree();
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.left.left = new TreeNode(4);

    System.out.println(fullBinaryTree.isFullTree(node));

  }
}
