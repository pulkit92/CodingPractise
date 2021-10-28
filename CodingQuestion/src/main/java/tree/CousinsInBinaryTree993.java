/*
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CousinsInBinaryTree993 {
  static TreeNode root;

  public static void main(String[] args) {
    CousinsInBinaryTree993 i = new CousinsInBinaryTree993();
    i.root = new TreeNode(1);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(3);
    i.root.right.right = new TreeNode(5);
    i.root.left.right = new TreeNode(4);

    System.out.println(i.isCousins(root, 4, 5));

  }

  public boolean isCousins(TreeNode root, int x, int y) {
    if (root == null) {
      return true;
    }
    Map<Integer, Pair> map = new HashMap<>();
    isCousins(root, x, y, map, 0);
  }

  public void isCousins(TreeNode root, int x, int y, Map<Integer, Pair> map, int d) {
    if (root == null) {
      return;
    }
    isCousins(root.left, x, y, map, d + 1);
    isCousins(root.right, x, y, map, d + 1);
    map.put(root);

  }

  static class Pair {
    TreeNode root;
    int dis;

    public TreeNode getRoot() {
      return root;
    }

    Pair(TreeNode root, int dis) {
      this.root = root;
      this.dis = dis;
    }

    public void setRoot(TreeNode root) {
      this.root = root;
    }

    public int getDis() {
      return dis;
    }

    public void setDis(int dis) {
      this.dis = dis;
    }

  }
}
*/
