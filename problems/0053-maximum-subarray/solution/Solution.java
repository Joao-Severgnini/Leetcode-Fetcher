class Solution {
    public int maxSubArray(int[] nums) {
        // Initialize 'res' with the first element of the array.
        // This ensures that even if all elements are negative, we return the largest one.
        int res = nums[0];

        // 'total' keeps track of the current subarray sum
        int total = 0;

        // Loop through each number in the array
        for (int n : nums) {
            // If the current total is negative, reset it to 0
            // because adding a negative sum won't help maximize the result
            if (total < 0) {
                total = 0;
            }

            // Add the current number to the total
            total += n;

            // Update the result with the maximum value between 'res' and 'total'
            res = Math.max(res, total);
        }

        // Return the maximum subarray sum found
        return res;
    }
}
