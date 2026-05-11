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
    // Breath First Search
    // BFS uses a Queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        // populate queue to start
        q.add(root);

        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            
            int currentQSize = q.size();
            for (int i = 0; i < currentQSize; i++) {
                TreeNode current = q.poll();
                if (current != null) {
                    q.add(current.left);
                    q.add(current.right);
                    level.add(current.val);
                }
            }
            if (level.size() > 0) result.add(level);
        }

        return result;       
    }
}
