package tree;

public class CousinsInABinaryTree {

  public boolean isCousins(TreeNode root, int x, int y) {
    int h1 = getheight(root, x, 1);
    int h2 = getheight(root, y, 1);
    if (h1 == h2 && !isCousinspossible(root, x, y)) {
      return true;
    }
    return false;
  }

  public boolean isCousinspossible(TreeNode root, int x, int y) {
    if (root == null) {
      return false;
    }
    if (root.left != null && root.right != null) {
      if ((root.right.val == x && root.left.val == y) || (root.left.val == x && root.right.val == y)
          || isCousinspossible(root.left
          , x, y) || isCousinspossible(root.right, x, y)) {
        return true;
      }

    }
    return false;
  }


  public int getheight(TreeNode root, int x, int level) {
    if (root == null) {
      return 0;
    }
    if (root.val == x) {
      return level;
    }

    int downlevel = getheight(root.left, x, level + 1);
    if (downlevel != 0) {
      return downlevel;
    }
    downlevel = getheight(root.right, x, level + 1);
    if (downlevel != 0) {
    }
    return downlevel;
  }

  public static void main(String args[]) {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.left.right = new TreeNode(4);
    treeNode.right = new TreeNode(3);
    treeNode.right.right = new TreeNode(5);
    CousinsInABinaryTree cousinsInABinaryTree = new CousinsInABinaryTree();
    System.out.println(cousinsInABinaryTree.isCousins(treeNode, 4, 5));
  }
}

