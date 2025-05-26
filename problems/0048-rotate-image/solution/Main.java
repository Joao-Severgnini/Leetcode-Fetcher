public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 3x3 matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(matrix);

        solution.rotate(matrix);

        System.out.println("Matrix after rotation:");
        printMatrix(matrix);
    }

    // Utility method to print a 2D matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
