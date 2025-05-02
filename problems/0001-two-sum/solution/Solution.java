import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store numbers and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement needed to reach the target
            int need = target - nums[i];

            // If the complement already exists in the map, return the pair of indices
            if (map.containsKey(need)) {
                return new int[] {map.get(need), i};
            }

            // Store the current number and its index in the map
            map.put(nums[i], i);
        }

        // Return an empty array if no solution is found
        return new int[] {};
    }
}
