public class Main {
    public static void main(String[] args) {
        // Using a factory method to create the tree nodes more conveniently
        TreeNode root = TreeNode.of(3,
            TreeNode.of(1,
                TreeNode.of(3, null, null), // Left subtree of node 1
                TreeNode.of(5,
                    null,
                    TreeNode.of(7, null, null)) // Right child of node 5
            ),
            TreeNode.of(4,
                null,
                TreeNode.of(1, null, null)) // Right child of node 4
        );

        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Call the goodNodes method, passing the root of the tree
        int result = solution.goodNodes(root);

        // Print the result
        System.out.println("Number of good nodes: " + result);
    }
}
