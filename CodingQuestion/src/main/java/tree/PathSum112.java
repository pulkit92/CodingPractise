package tree;

public class PathSum112 {
  static TreeNode root;


  public boolean hasPathSum(TreeNode root, int sum) {
    if (root != null) {
      if (root.right == null && root.left == null && sum - root.val == 0) {
        return true;
      }
      return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
    return false;
  }

  public static void main(String[] args) {
    PathSum112 p = new PathSum112();
    p.root = new TreeNode(5);
    p.root.left = new TreeNode(4);
    p.root.right = new TreeNode(8);
    p.root.left.left = new TreeNode(11);
    p.root.left.left.right = new TreeNode(7);
    p.root.left.left.left = new TreeNode(2);

    System.out.println(p.hasPathSum(root, 22));
  }
}
