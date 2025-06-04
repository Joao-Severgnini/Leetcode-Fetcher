import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {

            // Current interval ends before the new interval starts
            if (interval[1] < newInterval[0]) {
                res.add(interval);
            }

            // Current interval starts after the new interval ends
            else if (interval[0] > newInterval[1]) {
                res.add(newInterval);     // Add the merged/new interval before continuing
                newInterval = interval;   // Update the newInterval to keep processing
            }

            // Overlapping intervals, merge them
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        // Add the final merged interval
        res.add(newInterval);

        // Convert list to array and return
        return res.toArray(new int[res.size()][]);
    }
}
