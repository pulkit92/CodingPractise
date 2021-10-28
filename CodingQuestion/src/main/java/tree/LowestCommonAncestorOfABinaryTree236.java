package tree;

public class LowestCommonAncestorOfABinaryTree236 {
  static TreeNode root;

  public static void main(String[] args) {
    LowestCommonAncestorOfABinaryTree236 i = new LowestCommonAncestorOfABinaryTree236();
    i.root = new TreeNode(3);
    i.root.left = new TreeNode(5);
    i.root.right = new TreeNode(1);
    i.root.left.left = new TreeNode(6);
    i.root.left.right = new TreeNode(2);
    i.root.left.right.left = new TreeNode(7);
    i.root.left.right.right = new TreeNode(4);
    i.root.right.left = new TreeNode(0);
    i.root.right.right = new TreeNode(8);
    System.out.println(i.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4)).val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if ((p.val == root.val || q.val == root.val) && (left != null || right != null)) {
      return root;
    } else if (p.val == root.val) {
      return p;
    } else if (q.val == root.val) {
      return q;
    } else if (left != null && right != null) {
      return root;
    } else if (left != null) {
      return left;
    } else if (right != null) {
      return right;
    } else {
      return null;
    }

  }
}
