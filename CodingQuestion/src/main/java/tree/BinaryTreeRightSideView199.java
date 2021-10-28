package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView199 {
  static TreeNode root;
  static int max;
  public static void main(String[] args) {
    BinaryTreeRightSideView199 i = new BinaryTreeRightSideView199();
    i.root = new TreeNode(1);
    /*i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(3);
    i.root.left.right = new TreeNode(5);
    i.root.right.right = new TreeNode(4);*/

    System.out.println(i.rightSideView(root));

  }

  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    rightSideView(root, list, 1);
    return list;
  }

  public void rightSideView(TreeNode root, List<Integer> list, int level) {
    if (root == null) {
      return;
    }
    if (level > max) {
      list.add(root.val);
      max = level;
    }
    rightSideView(root.right, list,  level + 1);
    rightSideView(root.left, list,  level+1 );

  }
}
