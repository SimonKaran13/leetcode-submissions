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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    private TreeNode bruteForce(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val && isDescendant(root, q)) return root;
        if (root.val == q.val && isDescendant(root, p)) return root;

        boolean isPLeftDescendant = isDescendant(root.left, p);
        boolean isQLeftDescendant = isDescendant(root.left, q);
        if (isPLeftDescendant && isQLeftDescendant) {
            return lowestCommonAncestor(root.left, p, q);
        }

        boolean isPRightDescendant = isDescendant(root.right, p);
        boolean isQRightDescendant = isDescendant(root.right, q);
        if (isPRightDescendant && isQRightDescendant) {
            return lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    private boolean isDescendant(TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (root.val == p.val) return true;

        return isDescendant(root.left, p) || isDescendant(root.right, p);
    }
}
