class Solution {
    public void rotate(int[][] matrix) {
        // Initialize left and right boundaries (L and R) for the outermost layer
        int L = 0, R = matrix.length - 1;

        // Process layers from the outside to the inside
        while (L < R) {
            // For each square layer, rotate the four sides
            for (int i = 0; i < (R - L); i++) {
                int top = L;       // Top boundary of the current layer
                int bottom = R;    // Bottom boundary of the current layer

                // Store the top-left value in a temporary variable
                int topLeft = matrix[top][L + i];

                // Move value from bottom-left to top-left
                matrix[top][L + i] = matrix[bottom - i][L];

                // Move value from bottom-right to bottom-left
                matrix[bottom - i][L] = matrix[bottom][R - i];

                // Move value from top-right to bottom-right
                matrix[bottom][R - i] = matrix[top + i][R];

                // Move saved top-left value to top-right
                matrix[top + i][R] = topLeft;
            }

            // Move inwards to the next layer
            L++;
            R--;
        }
    }
}
