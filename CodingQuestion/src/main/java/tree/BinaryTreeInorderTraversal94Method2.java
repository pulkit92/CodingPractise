package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94Method2 {
  static TreeNode root;

  public static void main(String[] args) {
    BinaryTreeInorderTraversal94Method2 i = new BinaryTreeInorderTraversal94Method2();
    i.root = new TreeNode(1);
    i.root.right = new TreeNode(2);
    i.root.right.left = new TreeNode(3);
    System.out.println(i.inorderTraversal(root));
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list =new ArrayList<>();
    Stack<TreeNode> st=new Stack<>();
    TreeNode curr=root;
    st.push(root);
    while (!st.isEmpty()||curr!=null){
      while(curr!=null)
      {
        st.push(curr);
        curr=curr.left;
      }
      curr=st.pop();
      list.add(curr.val);
      curr=curr.right;

    }
    return list;

  }

}

