package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {
  TreeNode root;

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> list = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    if (root == null) {
      return list;
    }
    queue.add(root);
    while (!queue.isEmpty()) {
      long sum = 0;
      int count = 0;
      Queue<TreeNode> temp = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode treeNode = queue.remove();
        sum = sum + (treeNode.val);
        count++;
        if (treeNode.left != null) {
          temp.add(treeNode.left);
        }
        if (treeNode.right != null) {
          temp.add(treeNode.right);
        }
        queue = temp;
        list.add((sum / count) * 1.0);
      }

    }
    return list;
  }

  void printGivenLevel(TreeNode root, int level, List<Integer> values) {
    if (root == null) {
      return;
    }
    if (level == 1) {
      values.add(root.val);

    } else if (level > 1) {
      printGivenLevel(root.left, level - 1, values);
      printGivenLevel(root.right, level - 1, values);
    }
  }


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
    AverageOfLevelsInBinaryTree637 a = new AverageOfLevelsInBinaryTree637();
    a.root = new TreeNode(3);
    a.root.left = new TreeNode(9);
    a.root.right = new TreeNode(20);
    a.root.right.left = new TreeNode(15);
    a.root.right.right = new TreeNode(11);

    System.out.println(a.averageOfLevels(a.root));
  }
}
