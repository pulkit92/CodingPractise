package tree;

public class LowestCommonAncestorOFABinarySearchTree235 {
  static TreeNode root;

  public static void main(String[] args) {
    LowestCommonAncestorOFABinarySearchTree235 i = new LowestCommonAncestorOFABinarySearchTree235();
    i.root = new TreeNode(5);
    i.root.left = new TreeNode(3);
    i.root.right = new TreeNode(6);
    i.root.left.left = new TreeNode(2);
    i.root.left.right = new TreeNode(4);
    i.root.right.right = new TreeNode(7);
    System.out.println(i.lowestCommonAncestor(root, new TreeNode(6), new TreeNode(4)).val);
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root==null)
      return null;
    if(p.val>root.val&&q.val>root.val)
      return lowestCommonAncestor( root.right,  p,  q);
    else if (root.val>p.val&&root.val>q.val)
      return lowestCommonAncestor( root.left,  p,  q);

    return root;

  }
}
