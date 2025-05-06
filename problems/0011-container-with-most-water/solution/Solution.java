class Solution {
    public int maxArea(int[] height) {

        // Variable to store the maximum area found so far
        int ans = 0;

        // Two-pointer approach: one starting from the left and the other from the right
        int left = 0, right = height.length - 1, res = 0;

        // Continue until the two pointers meet
        while (left <= right) {

            // Calculate the area using the shorter line as height and distance between lines as width
            if (height[left] <= height[right]) {
                res = height[left] * (right - left);
                left++; // Move left pointer to the right to possibly find a taller line
            } else {
                res = height[right] * (right - left);
                right--; // Move right pointer to the left to possibly find a taller line
            }

            // Update max area if current area is greater
            if (res > ans) {
                ans = res;
            }
        }

        // Return the maximum area found
        return ans;
    }
}
