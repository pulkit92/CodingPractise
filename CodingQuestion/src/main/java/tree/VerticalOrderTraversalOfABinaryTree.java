package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
  Map<Integer, List<Integer>> map = new TreeMap<>();

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> list = new ArrayList<>();
    if (root == null) {
      return list;
    }
    Holder h = new Holder(root, 0);
    Queue<Holder> queue = new LinkedList<>();
    ((LinkedList<Holder>) queue).push(h);
    while (!queue.isEmpty()) {
      Holder hol = ((LinkedList<Holder>) queue).pop();
      List<Integer> list1 = map.getOrDefault(hol.i, new ArrayList<>());
      list1.add(hol.node.val);
      map.put(hol.i, list1);
      if (hol.node.left != null) {
        ((LinkedList<Holder>) queue).push(new Holder(hol.node.left, hol.i - 1));
      }
      if (hol.node.right != null) {
        ((LinkedList<Holder>) queue).push(new Holder(hol.node.right, hol.i + 1));
      }
    }
    for(int key:map.keySet()){
      list.add(map.get(key));
    }
    return list;
  }

}


class Holder {
  TreeNode node;
  Integer i;

  public Holder(TreeNode node, int i) {
    this.node = node;
    this.i = i;
  }
}