class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        // Perform binary search while the search space is valid
        while (left <= right) {
            int mid = (left + right) / 2;

            // If the target is found at the middle, return its index
            if (target == nums[mid]) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Target is outside the sorted left half
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            } 
            // Otherwise, the right half must be sorted
            else {
                // Target is outside the sorted right half
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            }
        }

        // If the target was not found
        return -1;
    }
}
