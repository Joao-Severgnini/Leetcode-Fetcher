public class Main {
    public static void main(String[] args) {
        // Constructing the binary tree:
        //        1
        //       / \
        //      2   3
        //     / \     
        //    4   5    
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3);
        TreeNode root = new TreeNode(1, node2, node3);

        Solution solution = new Solution();
        int diameter = solution.diameterOfBinaryTree(root);

        System.out.println("Diameter of the binary tree: " + diameter);
    }
}