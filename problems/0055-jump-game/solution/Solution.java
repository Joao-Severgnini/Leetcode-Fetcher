class Solution {
    public boolean canJump(int[] nums) {
        // Set the goal as the last index
        int goal = nums.length - 1;

        // Traverse the array from end to start
        for (int i = nums.length - 1; i >= 0; i--) {
            // If from index i, we can jump to or beyond the current goal
            if (i + nums[i] >= goal) {
                // Then update the goal to the current index
                goal = i;
            }
        }

        // If we managed to bring the goal to index 0, return true
        return goal == 0;
    }
}
