import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Edge case: if grid is null or empty
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rows = grid.length;
        int columns = grid[0] == null ? 0 : grid[0].length;

        // Queue to perform BFS starting from all initially rotten oranges
        Queue<int[]> queue = new LinkedList<>();

        int minutes = 0;      // To track time needed to rot all oranges
        int freshCount = 0;   // To count fresh oranges

        // Possible directions: up, down, left, right
        int[][] directions = {
            {-1, 0},  // up
            { 1, 0},  // down
            { 0, -1}, // left
            { 0, 1}   // right
        };

        // Initialize the queue with all rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (grid[r][c] == 1) {
                    freshCount++;
                } else if (grid[r][c] == 2) {
                    queue.offer(new int[] {r, c});
                }
            }
        }

        // If there are no fresh oranges, return 0 (no time needed)
        if (freshCount == 0) {
            return 0;
        }

        // Perform BFS to simulate the spread of rot each minute
        while (!queue.isEmpty() && freshCount > 0) {
            int queueSize = queue.size(); // Number of rotten oranges to process this minute

            for (int i = 0; i < queueSize; i++) {
                int[] curr = queue.poll();

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newRow = curr[0] + dir[0];
                    int newCol = curr[1] + dir[1];

                    // If adjacent cell is within bounds and has a fresh orange
                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < columns &&
                        grid[newRow][newCol] == 1) {

                        // Rot the fresh orange
                        grid[newRow][newCol] = 2;
                        queue.offer(new int[] {newRow, newCol});
                        freshCount--; // Decrease count of fresh oranges
                    }
                }
            }

            // Only increment minutes if there are still oranges to process
            if (!queue.isEmpty()) {
                minutes++;
            }
        }

        // If all fresh oranges are rotten, return time taken; otherwise return -1
        return freshCount == 0 ? minutes : -1;
    }
}
