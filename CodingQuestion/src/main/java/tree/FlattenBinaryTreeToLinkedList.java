package tree;

public class FlattenBinaryTreeToLinkedList {
  public static void main(String args[]) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(5);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(4);
    node.right.right = new TreeNode(6);

    FlattenBinaryTreeToLinkedList flattenBinaryTreeToLinkedList = new FlattenBinaryTreeToLinkedList();
    flattenBinaryTreeToLinkedList.flatten(node);
  }

  public void flatten(TreeNode root) {
    util(root);
  }

  public TreeNode util(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode leftFlat = util(root.left);
    TreeNode rightFlat = util(root.right);
    TreeNode temp = leftFlat;
    TreeNode temp1 = leftFlat;
    while (temp != null) {
      temp1 = temp;
      temp = temp.right;
    }
    if (temp1 != null) {
      temp1.right = rightFlat;
    }
    if (leftFlat != null) {
      root.right = leftFlat;

    } else {
      root.right = rightFlat;
    }

    root.left = null;
    return root;
  }

  private void print(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.println(node.val);
    print(node.left);
    print(node.right);
  }
}
