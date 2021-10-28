package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
  static TreeNode root;

  public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> list = new ArrayList<>();
    inorderTraversal(root, list);
    return list;
  }

  public void inorderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }
    inorderTraversal(root.left, list);
    list.add(root.val);
    inorderTraversal(root.right, list);

  }

  public static void main(String[] args) {
    BinaryTreeInorderTraversal94 i = new BinaryTreeInorderTraversal94();
    i.root = new TreeNode(1);
    i.root.right = new TreeNode(2);
    i.root.right.left = new TreeNode(3);
    System.out.println(i.inorderTraversal(root));
  }

}
