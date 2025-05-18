import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the array to make it easier to skip duplicates
        Arrays.sort(candidates);
        dfs(0, new ArrayList<>(), 0, candidates, target);
        return res;
    }

    public void dfs(int i, List<Integer> comb, int total, int[] candidates, int target){
        // Base case: if the current total equals target, add the combination to result
        if (total == target) {
            res.add(new ArrayList<>(comb));
            return;
        }

        // If out of bounds or total exceeds target, return
        if (i >= candidates.length || total > target) {
            return;
        }

        // Choose the current candidate
        comb.add(candidates[i]);
        dfs(i + 1, comb, total + candidates[i], candidates, target);
        comb.remove(comb.size() - 1); // backtrack

        // Skip all duplicates
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        // Don't choose the current candidate
        dfs(i + 1, comb, total, candidates, target);
    }
}
