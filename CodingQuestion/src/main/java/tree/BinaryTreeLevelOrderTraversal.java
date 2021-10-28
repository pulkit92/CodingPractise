package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  static TreeNode root;

  public static void main(String[] args) {
    BinaryTreeLevelOrderTraversal i = new BinaryTreeLevelOrderTraversal();
    i.root = new TreeNode(4);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(7);
    i.root.left.left = new TreeNode(1);
    i.root.left.right = new TreeNode(3);
    i.root.right.left = new TreeNode(6);
    i.root.right.right = new TreeNode(5);
    System.out.println(i.levelOrder(root));
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
      list.add(0,list1);

    }

    return list;
  }

}
