package tree;

public class InvertBinaryTree {
  static TreeNode root;

  public static void main(String[] args) {
    InvertBinaryTree i = new InvertBinaryTree();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    i.root.right.left = new TreeNode(6);
    i.root.right.right = new TreeNode(5);
    i.invertTree(root);

  }

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }
    TreeNode left = invertTree(root.left);
    TreeNode right = invertTree(root.right);
    root.left = right;
    root.right = left;
    return root;

  }
}
