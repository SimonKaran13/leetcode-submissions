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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        else return String.join(
            ",",
            root.val + "", serialize(root.left), serialize(root.right));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        int[] idxPointer = { 0 };
        return dfs(strings, idxPointer);
    }

    public TreeNode dfs(String[] strings, int[] idxPointer) {
        int idx = idxPointer[0];
        if (strings[idx].equals("#")) {
            idxPointer[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strings[idx]));
        idxPointer[0]++;

        root.left = dfs(strings, idxPointer);
        root.right = dfs(strings, idxPointer);
        return root;
    }

}
