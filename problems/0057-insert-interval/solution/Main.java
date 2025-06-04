import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] intervals = { {1, 3}, {6, 9} };
        int[] newInterval = {2, 5};

        int[][] result = sol.insert(intervals, newInterval);

        System.out.println("Merged Intervals:");
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
