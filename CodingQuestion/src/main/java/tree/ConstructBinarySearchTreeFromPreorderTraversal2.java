package tree;

public class ConstructBinarySearchTreeFromPreorderTraversal2 {
  public static void main(String args[]) {
    int a[] = {8, 5, 1, 7, 10, 12};
    ConstructBinarySearchTreeFromPreorderTraversal2 c = new ConstructBinarySearchTreeFromPreorderTraversal2();
    c.bstFromPreorder(a);
  }

  static int i = 0;

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder == null || preorder.length == 0) {
      return null;
    }
    return bstFromPreOrder(preorder, preorder.length);

  }

  public TreeNode bstFromPreOrder(int[] preorder, int l) {
    if (i < l) {
      TreeNode node = new TreeNode(preorder[i]);
      if (i > 0 && preorder[i - 1] < preorder[i]) {
        i=i-1;
        return null;
      }
      i = i + 1;
      node.left = bstFromPreOrder(preorder, l);
      i = i + 1;
      node.right = bstFromPreOrder(preorder, l);

      return node;
    }
    return null;
  }
}

