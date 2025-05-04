public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
   // Método de fábrica para facilitar a criação dos nós
  public static TreeNode of(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }
}