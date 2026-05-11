/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Here we can check the subtrees and see that the values are within a bounded area

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        return isValid(root.left, -1001, root.val) && isValid(root.right, root.val, 1001);
    }

    private boolean isValid(TreeNode root, int lower, int upper) {
        if (root == null) return true;
        if (root.val <= lower || root.val >= upper) return false;
        return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
    }
}
