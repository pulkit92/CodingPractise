package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversalGFG {
  public void reversePrint(TreeNode node) {

      if (node == null) {
        return;
      }
      Queue<TreeNode> q1 = new LinkedList<>();
      Queue<TreeNode> q2 = new LinkedList<>();
      q1.add(node);
      List<List<Integer>> out = new ArrayList<>();
      while (!q1.isEmpty() || !q2.isEmpty()) {
        List<Integer> tem = new ArrayList<>();
        while (!q1.isEmpty()) {
          TreeNode p = q1.poll();
          tem.add(p.val);
          if (p.left != null) {
            q2.add(p.left);
          }
          if (p.right != null) {
            q2.add(p.right);
        }
      }
      if (tem.size()>0) {
        out.add(tem);
      }
      List<Integer> tem1 = new ArrayList<>();
      while (!q2.isEmpty()) {
        TreeNode p = q2.poll();
        tem1.add(p.val);
        if (p.left != null) {
          q1.add(p.left);
        }
        if (p.right != null) {
          q1.add(p.right);
        }
      }
      if (tem1.size()>0) {
        out.add(tem1);
      }
    }
    for (List<Integer> lis : out) {
      for (int i : lis) {
        System.out.print(i + " ");

      }
    }

  }

  public static void main(String args[]) {
    TreeNode treeTreeNode = new TreeNode(7);
    treeTreeNode.left = new TreeNode(9);
    treeTreeNode.left.right = new TreeNode(9);
    treeTreeNode.left.right.right = new TreeNode(10);
    treeTreeNode.right = new TreeNode(4);
    treeTreeNode.right.right = new TreeNode(10);
    treeTreeNode.right.left = new TreeNode(6);
    treeTreeNode.right.left.left = new TreeNode(6);
    ReverseLevelOrderTraversalGFG reverseLevelOrderTraversalGFG = new ReverseLevelOrderTraversalGFG();
    reverseLevelOrderTraversalGFG.reversePrint(treeTreeNode);
  }
}
