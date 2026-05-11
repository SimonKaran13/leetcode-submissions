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

    
    
    private int maxHeight = 0;

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return List.of();
        List<Integer> values = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
        
            TreeNode rightMostNode = null;
            int qLen = queue.size();

             for (int i = 0; i < qLen; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                rightMostNode = node;
                queue.add(node.left);
                queue.add(node.right);
            }

            if (rightMostNode != null) {
                values.add(rightMostNode.val);
            }
        }

        return values;
    }
}
