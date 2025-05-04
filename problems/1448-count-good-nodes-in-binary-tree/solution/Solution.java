/**
 * Definition for a binary tree node.
 * (LeetCode usually provides this for tree problems)
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
    // Counter for the number of good nodes
    int good;

    // Main method to count good nodes in the binary tree
    public int goodNodes(TreeNode root) {
        good = 0; // Reset counter
        call(root, Integer.MIN_VALUE); // Start recursion with the minimum possible value
        return good; // Return the result
    }

    // Helper recursive method to traverse the tree
    private void call(TreeNode root, int max) {
        // Base case: if the node is null, return
        if (root == null) {
            return;
        }

        // If the current node's value is greater than or equal to the max value seen so far,
        // it's a "good" node
        if (root.val >= max) {
            good++; // Increment good node count
        }

        // Update the max value with the current node's value
        max = Math.max(max, root.val);

        // Recursively check left and right subtrees
        call(root.left, max);
        call(root.right, max);
    }
}
