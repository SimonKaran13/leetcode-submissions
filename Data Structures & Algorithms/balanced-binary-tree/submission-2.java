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

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        if (!isBalanced(root.left)) {
            return false;
        }

        if (!isBalanced(root.right)) {
            return false;
        } 

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int diff = Math.abs(leftHeight - rightHeight);
        return diff <= 1;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        
        return 1 + Math.max(height(root.right), height(root.left));
    }
}
