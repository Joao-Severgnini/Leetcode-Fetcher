public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[] nums1 = {2, 3, 1, 1, 4}; // Expected: true
        int[] nums2 = {3, 2, 1, 0, 4}; // Expected: false

        System.out.println("Can jump (nums1): " + solution.canJump(nums1));
        System.out.println("Can jump (nums2): " + solution.canJump(nums2));
    }
}
