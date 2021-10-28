package tree;

public class SymmetricTree101 {
  static TreeNode root;

  public static void main(String[] args) {
    SymmetricTree101 i = new SymmetricTree101();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    i.root.right.left = new TreeNode(6);
    i.root.right.right = new TreeNode(5);
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isSymmetric(root.left, root.right);

  }

  public boolean isSymmetric(TreeNode left, TreeNode right) {
    if (left.val != right.val) {
      return false;
    }
    if (right == null && left == null) {
      return true;
    }

    if (right == null || left == null) {
      return false;
    }


    return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

  }

}