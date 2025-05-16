public class Main {
    public static void main(String[] args) {
        // Rotated sorted array
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        // Target value to search for
        int target = 0;

        Solution solution = new Solution();
        int index = solution.search(nums, target);

        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found in the array.");
        }
    }
}
