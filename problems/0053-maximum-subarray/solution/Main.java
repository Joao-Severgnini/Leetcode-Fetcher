public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4}; // Exemplo clássico
        int maxSum = solution.maxSubArray(nums);

        System.out.println("Maximum subarray sum: " + maxSum);
    }
}
