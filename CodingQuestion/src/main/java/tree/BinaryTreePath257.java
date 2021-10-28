package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath257 {
  static TreeNode root;

  public static void main(String[] args) {
    BinaryTreePath257 i = new BinaryTreePath257();
    i.root = new TreeNode(1);
    i.root.left = new TreeNode(2);
    i.root.right = new TreeNode(3);
    i.root.left.right = new TreeNode(5);

    i.binaryTreePaths(root);

  }

  public List<String> binaryTreePaths(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    List<String> output = new ArrayList<>();
    binaryTreePaths(root, list, temp);
    for(List<Integer> l:list){
      StringBuffer sb=new StringBuffer();
        for (Integer i:l){
          sb.append(String.valueOf(i));
        }
    }
    return output;

  }

  public void binaryTreePaths(TreeNode root, List<List<Integer>> list, List<Integer> temp) {

    if (root != null) {

      if (root.right == null && root.left == null) {
        list.add(temp);
        temp.remove(temp.size() - 1);
      }
      temp.add(root.val);
      binaryTreePaths(root.left, list, temp);
      binaryTreePaths(root.right, list, temp);
    }
  }
}
