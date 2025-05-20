class Solution {
    public int trap(int[] height) {
        // If the input array is null, no water can be trapped
        if (height == null) {
            return 0;
        }

        // Initialize two pointers: one at the beginning and one at the end
        int l = 0;
        int r = height.length - 1;

        // Keep track of the maximum height from the left and the right
        int leftMax = height[l];
        int rightMax = height[r];

        // Variable to store the total amount of trapped water
        int water = 0;

        // Traverse the array until the two pointers meet
        while (l < r) {
            // If the height at the left pointer is less than at the right pointer,
            // process from the left side
            if (height[l] < height[r]) {
                l++; // Move left pointer to the right
                leftMax = Math.max(leftMax, height[l]); // Update left max height
                water += leftMax - height[l]; // Add trapped water at this position
            } else {
                // Otherwise, process from the right side
                r--; // Move right pointer to the left
                rightMax = Math.max(rightMax, height[r]); // Update right max height
                water += rightMax - height[r]; // Add trapped water at this position
            }
        }

        // Return the total amount of trapped water
        return water;
    }
}
