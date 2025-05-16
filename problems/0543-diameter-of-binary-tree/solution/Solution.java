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
    // Variable to store the maximum diameter found during traversal
    int res = 0;

    // Main function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root); // Start DFS traversal from the root
        return res; // Return the maximum diameter found
    }

    // Helper function that performs DFS and returns the height of the current subtree
    public int dfs(TreeNode cur) {
        if (cur == null) {
            return 0; // If the current node is null, its height is 0
        }

        int left = dfs(cur.left);   // Recursively get the height of the left subtree
        int right = dfs(cur.right); // Recursively get the height of the right subtree

        // Update the result with the maximum diameter found so far
        // Diameter at the current node = left height + right height
        res = Math.max(res, left + right);

        // Return the height of the current node = 1 + max height of its subtrees
        return 1 + Math.max(left, right);
    }
}