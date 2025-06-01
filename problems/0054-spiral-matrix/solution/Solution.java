import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Method to return the spiral order of the matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;

        while (left < right && top < bottom) {
            // Traverse the top row from left to right
            for (int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            // Traverse the rightmost column from top to bottom
            for (int i = top; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;

            // Check if we still have rows and columns to process
            if (!(left < right && top < bottom)) {
                break;
            }

            // Traverse the bottom row from right to left
            for (int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;

            // Traverse the leftmost column from bottom to top
            for (int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
