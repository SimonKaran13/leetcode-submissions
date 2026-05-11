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
        diameter(root);
        return res;
    }

    private int diameter(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int right = diameter(node.right);
        int left = diameter(node.left);

        res = Math.max(res, left + right);

        return 1 + Math.max(left, right);
    }
}
