package tree;

/*
import java.util.List;

public class tree.AllNodesDistanceKInBinaryTree {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

  }
}
*/
public   class AllNodesDistanceKInBinaryTree {
  final long id;
  final long endTime;
  final boolean includeRaw;
  final int customerId;

  AllNodesDistanceKInBinaryTree(int customerId, long id, long endTime, boolean includeRaw) {
    this.customerId = customerId;
    this.id = id;
    this.endTime = endTime;
    this.includeRaw = includeRaw;

  }

  AllNodesDistanceKInBinaryTree(int customerId, long id, long endTime, boolean includeRaw, boolean fetchSecurityGrpsWithoutAcls) {
    this(customerId, id, endTime, includeRaw);
  }}
