package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InsertIntoABinarySearchTree701 {
  static TreeNode root;

  public static void main(String[] args) {
    InsertIntoABinarySearchTree701 i = new InsertIntoABinarySearchTree701();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    System.out.println(i.levelOrder(i.insertIntoBST(root, 5)));
  }

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      TreeNode r = new TreeNode(val);
      return r;
    }
    TreeNode left = null;
    if (val < root.val) {
      left = insertIntoBST(root.left, val);

    }
    TreeNode right = null;

    if (val > root.val) {
      right = insertIntoBST(root.right, val);
    }
    if (left != null) {
      root.left = left;
      return root;
    }
    if (right != null) {
      root.right = right;
    }
    return root;
  }

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      List<Integer> list1 = new ArrayList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode temp = queue.poll();
        list1.add(temp.val);
        if (null != temp.left) {
          queue.add(temp.left);
        }
        if (null != temp.right) {
          queue.add(temp.right);
        }
      }
      list.add(list1);


    }
    return list;
  }
}
