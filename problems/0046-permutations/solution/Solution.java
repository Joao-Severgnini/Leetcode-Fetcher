import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
      // Create the variable that stores the result (List<List<Integer>>)
       List<List<Integer>> result = new ArrayList<>();
       // Call the recursive backtrack method
       backtrack(result, new ArrayList<>(), nums);
       return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums){
      // If both has same length, we have one complete permutation
      if (current.size() == nums.length){
        // Add a copy, so we don't modify 'current' when we remove elements later
        result.add(new ArrayList<>(current));
        return;
      }
      // Iterate over each number
      for(int num : nums){
        // Check if we've already used this number in the current permutation
        if(current.contains(num)) continue;
        // Add it to 'current', and call backtrack again for next number
        current.add(num);
        backtrack(result, current, nums);
        // After the recursive call returns, remove the last digit and try another option
        current.remove(current.size() - 1);
      }
    }
}