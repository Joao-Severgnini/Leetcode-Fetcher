import java.util.ArrayList;
import java.util.List;

class Solution {
    // Result list to store all valid combinations
    List<List<Integer>> res = new ArrayList<>();

    // Entry point for combinationSum
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(0, new ArrayList<>(), 0, target, candidates);  // Start DFS from index 0
        return res;
    }

    // Recursive DFS method to explore all combinations
    public void dfs(int i, List<Integer> comb, int total, int target, int[] candidates) {
        // If the total equals target, we found a valid combination
        if (total == target) {
            res.add(new ArrayList<>(comb));  // Make a copy of the current combination
            return;
        }

        // If out of bounds or total exceeds target, stop recursion
        if (i >= candidates.length || total > target) {
            return;
        }

        // Include the current number and stay at same index (can reuse same element)
        comb.add(candidates[i]);
        dfs(i, comb, total + candidates[i], target, candidates);

        // Backtrack: remove last added number and try the next one
        comb.remove(comb.size() - 1);
        dfs(i + 1, comb, total, target, candidates);  // Move to next index
    }
}
