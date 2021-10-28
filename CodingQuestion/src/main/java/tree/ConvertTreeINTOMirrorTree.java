package tree;

import java.util.ArrayList;

public class ConvertTreeINTOMirrorTree {
  void mirror(TreeNode node) {
    // Your code here
    if (node == null) {
      return;
    }
    node = mirrorUtil(node);
    inorder(node);
    ArrayList <Integer> list=new ArrayList<>();
    //list.remove()

  }

  private void inorder(TreeNode node) {
    if (node != null) {
      inorder(node.left);
      System.out.println(node.val);
      inorder(node.right);
    }
  }

  TreeNode mirrorUtil(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode node = new TreeNode(root.val);
    node.left = mirrorUtil(root.right);
    node.right = mirrorUtil(root.left);
    return node;
  }

  public static void main(String args[]) {
    ConvertTreeINTOMirrorTree maximumWidthOfBinaryTree = new ConvertTreeINTOMirrorTree();
    TreeNode node = new TreeNode(10);
    node.left = new TreeNode(20);
    node.right = new TreeNode(30);
    node.left.left=new TreeNode(40);
    node.left.right=new TreeNode(60);
    maximumWidthOfBinaryTree.mirror(node);
  }
}
