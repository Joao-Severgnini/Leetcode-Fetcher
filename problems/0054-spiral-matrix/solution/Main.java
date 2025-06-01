import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Sample matrix input
        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        // Call the method and print result
        List<Integer> result = sol.spiralOrder(matrix);
        System.out.println("Spiral order: " + result);
    }
}
