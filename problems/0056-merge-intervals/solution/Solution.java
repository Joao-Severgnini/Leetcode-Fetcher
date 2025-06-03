import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort intervals by their starting point (interval[0])
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // List to store merged intervals
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {
            // If the list is empty or there is no overlap, add the interval
            if (res.isEmpty() || res.get(res.size() - 1)[1] < interval[0]) {
                res.add(interval);
            }

            // Merge overlapping intervals by updating the end value
            res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], interval[1]);
        }

        // Convert list of arrays to a 2D array and return it
        return res.toArray(new int[res.size()][]);
    }
}
