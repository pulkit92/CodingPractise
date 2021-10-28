package tree;

public class SameTree100 {
  static TreeNode root, root1;

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

  }

  public static void main(String[] args) {
    SameTree100 i = new SameTree100();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    i.root.right.left = new TreeNode(6);
    i.root.right.right = new TreeNode(5);
    i.root1 = new TreeNode(4);
    i.root1.left = new TreeNode(1);
    i.root1.right = new TreeNode(7);
    i.root1.left.left = new TreeNode(1);
    i.root1.left.right = new TreeNode(3);
    i.root1.right.left = new TreeNode(6);
    i.root1.right.right = new TreeNode(5);
    System.out.println(i.isSameTree(root, root1));
  }
}
