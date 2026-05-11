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
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        int[] goodNodesCount = new int[]{1};
        dfs(root.left, root.val, goodNodesCount);
        dfs(root.right, root.val, goodNodesCount);
        return goodNodesCount[0];
    }

    private void dfs(TreeNode root, int maxValue, int[] goodNodesCount) {
        if (root == null) return;
        if (root.val >= maxValue) {
            goodNodesCount[0] += 1;
        }
        int newMaxValue = Math.max(root.val, maxValue);
        dfs(root.left, newMaxValue, goodNodesCount);
        dfs(root.right, newMaxValue, goodNodesCount);
    }
}
