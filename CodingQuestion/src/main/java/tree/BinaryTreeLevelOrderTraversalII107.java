package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII107 {
  static TreeNode root;

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversalII107 i = new BinaryTreeLevelOrderTraversalII107();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    i.root.right.left = new TreeNode(6);
    i.root.right.right = new TreeNode(5);
    System.out.println(i.levelOrderBottom(root));
  }

  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> out = new ArrayList<>();
    levelOrderBottom(root, out, 0);
    return out;
  }

  public void levelOrderBottom(TreeNode root, List<List<Integer>> list, int level) {
    if (root == null) {
      return;
    }
    if (level >= list.size()) {
      list.add(level, new ArrayList<>());
    }
    levelOrderBottom(root.left, list, level + 1);
    levelOrderBottom(root.right, list, level + 1);
    list.get(list.size()-level-1).add(root.val);
  }

}
