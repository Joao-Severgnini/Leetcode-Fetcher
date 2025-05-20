public class Solution {
    // Finds the pivot index where the sum of the left elements equals the sum of the right elements
    public int pivotIndex(int[] nums) {
        int _sum = 0;      // Total sum of the array
        int leftSum = 0;   // Sum of elements to the left of current index

        // Calculate total sum of the array
        for (int e : nums) {
            _sum += e;
        }

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if left sum equals right sum (right sum = total - left - current)
            if (leftSum * 2 == _sum - nums[i]) {
                return i; // Pivot index found
            }
            leftSum += nums[i]; // Update left sum
        }

        // No pivot index found
        return -1;
    }
}
