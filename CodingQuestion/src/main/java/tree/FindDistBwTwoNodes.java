package tree;

public class FindDistBwTwoNodes {


  static TreeNode lca = null;

  boolean findLca(TreeNode root, TreeNode n1, TreeNode n2) {
    if (root == null) {
      return false;
    }
    int left = 0;
    if (findLca(root.left, n1, n2)) {
      left = 1;
    }
    int right = 0;
    if (findLca(root.right, n1, n2)) {
      right = 1;
    }
    int value = 0;
    if (root.val == n1.val || root.val == n2.val) {
      value = 1;
    }
    if (value + left + right >= 2) {
      lca = root;
    }
    return ((value + left + right) > 0);
  }

  int findDistance(TreeNode root, TreeNode node, int k) {
    if (root == null) {
      return 0;
    }
    if (root.val == node.val) {
      return k;
    }
    int l = findDistance(root.left, node, k + 1);
    if (l != 0) {
      return l;
    }
    return findDistance(root.right, node, k + 1);
  }

  public static void main(String args[]) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.left.left = new TreeNode(4);
    node.right = new TreeNode(3);
    node.right.left = new TreeNode(5);
    node.right.left.left = new TreeNode(7);
    node.right.right = new TreeNode(6);
    node.right.right.right = new TreeNode(9);
    node.right.right.left = new TreeNode(8);


    FindDistBwTwoNodes findDistBwTwoNodes = new FindDistBwTwoNodes();
    findDistBwTwoNodes.findLca(node, new TreeNode(7), new TreeNode(9));
    System.out.println(lca.val);
    int lcadist = findDistBwTwoNodes.findDistance(node, lca, 0);
    int dist1 = findDistBwTwoNodes.findDistance(node, new TreeNode(7), 0);

    int dist2 = findDistBwTwoNodes.findDistance(node, new TreeNode(9), 0);
    System.out.println(dist1+dist2-(2*lcadist));

  }


}
