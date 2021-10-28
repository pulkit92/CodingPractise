package tree;

import java.util.LinkedList;
import java.util.Queue;

public class KthSmallestElementInABST {
  public int kthSmallest(TreeNode root, int k) {
    //List<Integer> list=new ArrayList<>();
    // iterate( root, list);
    //if(list.size()>k){
    //     return list.get(k-1);
    // }
    // return k;

    Queue<TreeNode> queue = new LinkedList<>();

    while (true) {
      while (root != null) {
        queue.add(root);
        root = root.left;
      }
      root = queue.poll();
      if (--k == 0) {
        return root.val;
      }
      root = root.right;
    }


  }

  public static void main(String args[]) {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(1);
    treeNode.right = new TreeNode(4);
    treeNode.left.right = new TreeNode(2);
    KthSmallestElementInABST k = new KthSmallestElementInABST();
    k.kthSmallest(treeNode, 1);
  }
}
