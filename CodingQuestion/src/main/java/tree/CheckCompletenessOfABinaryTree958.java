package tree;

public class CheckCompletenessOfABinaryTree958 {
  static TreeNode root;

  int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int lheight = getHeight(root.left);
    int rheight = getHeight(root.right);
    if (lheight > rheight) {
      return lheight + 1;
    }
    return rheight + 1;

  }

  public static void main(String[] args) {
    CheckCompletenessOfABinaryTree958 a = new CheckCompletenessOfABinaryTree958();
    a.root = new TreeNode(3);
    a.root.left = new TreeNode(9);
    a.root.right = new TreeNode(20);
    a.root.right.left = new TreeNode(15);
    a.root.right.right = new TreeNode(11);




    System.out.println(a.isCompleteTree(a.root));
  }

  public boolean isCompleteTree(TreeNode root) {
    int h = getHeight(root);
    for (int i = 1; i <= h; i++) {
      if (!checkGivenLevel(root, i, i, h)) {
        return false;
      }
    }
    return true;
  }

    boolean checkGivenLevel(TreeNode root, int leveliterator, int exactlevel, int h) {
      if (root == null) {
        return false;
      }
      if (leveliterator == 1) {
        if (h - exactlevel > 1) {
          if (root.left == null || root.right == null) {
            return false;
          } else {
            return true;
          }

        }
        if (h - exactlevel == 1) {
          if (root.left == null) {
            return false;
          } else {
            return true;
          }
        }

      } else if (leveliterator > 1) {
        if (!checkGivenLevel(root.left, leveliterator - 1, exactlevel, h)) {
          return false;
        }
        if (!checkGivenLevel(root.right, leveliterator - 1, exactlevel, h)) {
          return false;
        }

      }
      return false;
    }
}

