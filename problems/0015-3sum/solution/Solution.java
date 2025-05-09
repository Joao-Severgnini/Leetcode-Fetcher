import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        // Result list to store all unique triplets
        List<List<Integer>> result = new ArrayList<>();

        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);

        // Iterate through the array, stopping 2 elements before the end
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first number in the triplet
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            // Use two-pointer approach to find pairs that sum with nums[i] to 0
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers after processing this triplet
                    left++;
                    right--;

                } else if (sum < 0) {
                    // If the sum is too small, move left pointer to the right
                    left++;
                } else {
                    // If the sum is too large, move right pointer to the left
                    right--;
                }
            }
        }

        // Return the list of triplets
        return result;
    }
}
