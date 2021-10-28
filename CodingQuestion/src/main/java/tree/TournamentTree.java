package tree;

/**
 * A tournament tree is a binary tree
 * where the parent is the minimum of the two children.
 * Given a tournament tree find the second minimum value in the tree.
 * A node in the tree will always have 2 or 0 children.
 * Also all leaves will have distinct and unique values.
 * 2
 * /    \
 * 2      3
 * / \    /  \
 * 4   2   5   3
 * <p>
 * In this given tree the answer is 3.
 */

public class TournamentTree {
    public static void main(String args[]) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.left.left = new TreeNode(3);
        treeNode.left.left.right = new TreeNode(1);
        treeNode.left.right = new TreeNode(1);

        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(3);
        treeNode.right.right = new TreeNode(4);
        TournamentTree tournamentTree = new TournamentTree();
        System.out.println(tournamentTree.findSecondMinimumValue(treeNode));
    }

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }
        int left = -1;
        if (root.left.val == root.val) {
            left=findSecondMinimumValue(root.left);
        }
        else {
            left=root.left.val;
        }
        int right=-1;
        if (root.right.val==root.val){
            right=findSecondMinimumValue(root.right);
        }
        else {
            right=root.right.val;
        }
        if (left==-1){
            return right;
        }
        if (right==-1){
            return left;
        }
        return left>right ? right:left;
    }

}