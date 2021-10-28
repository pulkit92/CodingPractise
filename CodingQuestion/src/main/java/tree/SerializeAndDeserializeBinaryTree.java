package tree;

public class SerializeAndDeserializeBinaryTree {

  public static void main(String args[]) {
    SerializeAndDeserializeBinaryTree serializeAndDeserializeBinaryTree = new SerializeAndDeserializeBinaryTree();
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(3);
    treeNode.right.left = new TreeNode(4);
    treeNode.right.right = new TreeNode(5);

    String serializedValue = serializeAndDeserializeBinaryTree.serialize(treeNode);
    TreeNode treeNode1 = serializeAndDeserializeBinaryTree.deserialize(serializedValue);
    System.out.println(treeNode1);
  }

  public String serialize(TreeNode root) {
    if (root == null) {
      return null;
    }

    return serialize(root, "");
  }

  public String serialize(TreeNode root, String s) {
    if (root == null) {
      s = s + "null,";
      return s;
    }
    s = s + (root.val + ",");

    s = serialize(root.left, s);
    s = serialize(root.right, s);
    return s;
  }

  public TreeNode deserialize(String data) {
    if (data == "") {
      return null;
    }
    String sna[] = data.split(",");
    return reDeserialize(sna, 0, sna.length);
  }

  public TreeNode reDeserialize(String sna[], int post, int len) {
    if (len < post) {
      return null;
    }
    TreeNode treeNode = null;
    if (sna[post].equals("null")) {
      return null;
    } else {
      treeNode = new TreeNode(Integer.parseInt(sna[post]));
    }

    treeNode.left = reDeserialize(sna, post + 1, len);
    treeNode.right = reDeserialize(sna, post + 1, len);
    return treeNode;
  }

}
