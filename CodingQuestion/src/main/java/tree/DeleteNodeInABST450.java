package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DeleteNodeInABST450 {
  static TreeNode root;

  public static void main(String[] args) {
    DeleteNodeInABST450 i = new DeleteNodeInABST450();
    i.root = new TreeNode(5);
    i.root.left = new TreeNode(3);
    i.root.right = new TreeNode(6);
    i.root.left.left = new TreeNode(2);
    i.root.left.right = new TreeNode(4);
    i.root.right.right = new TreeNode(7);
    System.out.println(i.levelOrder(i.deleteNode(root, 7)));
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    return deleteNode(root, null, key);
  }

  public TreeNode deleteNode(TreeNode root, TreeNode temp, int key) {
    if (root == null) {
      return null;
    }
    if (root.val == key) {
      if (root.right != null) {
        root = root.right;
      } else {
        return null;
      }
    }

    if (root.val > key) {
      temp=deleteNode(root.left, root,key);
    }
    if (root.val < key) {
      temp=deleteNode(root.right, root,key);


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
