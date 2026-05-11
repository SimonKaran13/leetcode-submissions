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
    int res = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return res;
    }

    // Regular height calculation
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int right = height(node.right);
        int left = height(node.left);

        // The result is the maximum sum of the left and right heights
        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }
}
