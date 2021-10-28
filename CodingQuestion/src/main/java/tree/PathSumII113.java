package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113 {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> out = new ArrayList<>();
    pathSum(root, sum, 0, out, new ArrayList<>());
    return out;
  }

  private void pathSum(TreeNode root, int sum, int sumPath, List<List<Integer>> out, ArrayList<Integer> temp) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null && sumPath + root.val == sum) {
      temp.add(root.val);
      List<Integer> copy = new ArrayList<>();
      copy.addAll(temp);
      out.add(copy);
      temp.remove(temp.size() - 1);
      return;
    }
    temp.add(root.val);
    pathSum(root.left, sum, sumPath + root.val, out, temp);
    pathSum(root.right, sum, sumPath + root.val, out, temp);
    temp.remove(temp.size() - 1);
    return;

  }

  public static void main(String args[]) {
    PathSumII113 pathSumII113 = new PathSumII113();
    TreeNode node = new TreeNode(5);
    node.left = new TreeNode(4);
    node.left.left = new TreeNode(11);
    node.left.left.right = new TreeNode(2);
    node.left.left.left = new TreeNode(7);
    node.right = new TreeNode(8);
    node.right.right = new TreeNode(4);
    node.right.left = new TreeNode(13);
    node.right.right.left = new TreeNode(5);
    node.right.right.right = new TreeNode(1);
    System.out.println(pathSumII113.pathSum(node, 22));

  }
}
