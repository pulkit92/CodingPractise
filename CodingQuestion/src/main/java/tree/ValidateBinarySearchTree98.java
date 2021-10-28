package tree;

public class ValidateBinarySearchTree98 {
  static TreeNode root;

  public static void main(String[] args) {
    ValidateBinarySearchTree98 i = new ValidateBinarySearchTree98();
    i.root = new TreeNode(1);
    i.root.right = new TreeNode(2);
    i.root.right.left = new TreeNode(3);
    System.out.println(i.isValidBST(root));
  }

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

  }

  public boolean isValidBST(TreeNode root, long min, long max) {
    if (root == null) {
      return true;
    }
    int val = root.val;
    if (val >= max || min >= val) {
      return false;
    }
    if (!isValidBST(root.left, min, val) || !isValidBST(root.right, val, max)) {
      return false;
    }
    return true;
  }
}