package tree;

public class ConstructBinarySearchTreeFromPreorderTraversal {
  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    TreeNode root = null;
    for (int i = 0; i < preorder.length; i++) {
      int value = preorder[i];
     root= util(value, root);
    }
    return root;
  }

  private TreeNode util(int value, TreeNode root) {
    if (root == null) {
      return new TreeNode(value);
    }
    if (root.val > value) {
      root.left = util(value, root.left);
    } else {
      root.right = util(value, root.right);
    }

    return root;
  }

  public static void main(String args[]) {
    int a[] = {8, 5, 1, 7, 10, 12};
    ConstructBinarySearchTreeFromPreorderTraversal c = new ConstructBinarySearchTreeFromPreorderTraversal();
    c.bstFromPreorder(a);
  }
}

