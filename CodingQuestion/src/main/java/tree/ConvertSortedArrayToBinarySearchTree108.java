package tree;

public class ConvertSortedArrayToBinarySearchTree108 {
  public static void main(String[] args) {
    ConvertSortedArrayToBinarySearchTree108 i = new ConvertSortedArrayToBinarySearchTree108();
    int a[] = {-10, -3, 0, 5, 9};
    System.out.println(i.sortedArrayToBST(a));
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    if (nums.length > 0) {
      return sortedArrayToBST(nums, 0, nums.length - 1);
    } else {
      return null;
    }
  }

  public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
    if (end >= start) {
      int mid = (end+start) / 2;
      TreeNode root = new TreeNode(nums[mid]);
      root.left = sortedArrayToBST(nums, start, mid - 1);
      root.right = sortedArrayToBST(nums, mid + 1, end);
      return root;
    }
    return null;
  }
}
