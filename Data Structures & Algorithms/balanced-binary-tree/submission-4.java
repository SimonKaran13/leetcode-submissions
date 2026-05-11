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
        int[] result = dfs(root);
        return result[1] == 1;       
    }

    // result[0] = height
    // result[1] = isBalanced
    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{1, 1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int heightDiff = Math.abs(left[0] - right[0]);
        
        int[] result = new int[2];
        int height = Math.max(left[0], right[0]);

        if (heightDiff > 1) {
            result[0] = height;
            result[1] = -1;
            return result;
        }

        int balanced = (left[1] == 1 && right[1] == 1) ? 1 : -1;
        result[0] = 1 + height;
        result[1] = balanced;
        return result;
    }
}
