import java.util.HashSet;

class Solution {
  @SuppressWarnings("unchecked")
    public boolean isValidSudoku(char[][] board) {
        // Create arrays of HashSets to track seen digits in rows, columns, and 3x3 boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize each HashSet for rows, columns, and boxes
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse each cell in the 9x9 board
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                // Skip empty cells represented by '.'
                if (board[r][c] == '.') {
                    continue;
                }

                char value = board[r][c];  // Current digit
                int boxIdx = (r / 3) * 3 + (c / 3);  // Determine which 3x3 box we're in

                // If the digit already exists in the current row, column, or box → invalid
                if (rows[r].contains(value) || cols[c].contains(value) || boxes[boxIdx].contains(value)) {
                    return false;
                }

                // Otherwise, mark the digit as seen in the current row, column, and box
                rows[r].add(value);
                cols[c].add(value);
                boxes[boxIdx].add(value);
            }
        }

        // If we finish without conflicts, the board is valid
        return true;
    }
}
