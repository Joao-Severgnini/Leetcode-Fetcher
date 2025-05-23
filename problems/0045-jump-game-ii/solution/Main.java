public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {2, 3, 1, 1, 4}; // Expected output: 2
        int result = solution.jump(nums);

        System.out.println("Minimum number of jumps: " + result);
    }
}
