import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // Initialize the board with '.' to represent empty cells
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');

        // List to store all valid solutions
        List<List<String>> ans = new ArrayList<>();

        // Start solving from the first column
        solve(0, ans, board);

        return ans;
    }

    private void solve(int col, List<List<String>> ans, char[][] board) {
        // Base case: If we've placed queens in all columns, record the solution
        if (col == board.length) {
            List<String> res = new LinkedList<>();
            for (int i = 0; i < board.length; i++) {
                String s = new String(board[i]);
                res.add(s);
            }
            ans.add(res);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int i = 0; i < board.length; i++) {
            if (validate(i, col, board)) {
                // Place queen
                board[i][col] = 'Q';

                // Recurse for the next column
                solve(col + 1, ans, board);

                // Backtrack and remove the queen
                board[i][col] = '.';
            }
        }
    }

    private boolean validate(int row, int col, char[][] board) {
        int oldR = row;
        int oldC = col;

        // Check the upper-left diagonal
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        // Reset row and col for next check
        row = oldR;
        col = oldC;

        // Check the left side (same row)
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;
            col--;
        }

        // Reset row and col for next check
        row = oldR;
        col = oldC;

        // Check the lower-left diagonal
        while (row < board.length && col >= 0) {
            if (board[row][col] == 'Q') return false;
            row++;
            col--;
        }

        // If no conflicts, it's a valid position
        return true;
    }
}
