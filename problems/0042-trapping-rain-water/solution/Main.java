public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test case
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = solution.trap(height);

        System.out.println("Trapped water: " + result);  // Expected output: 6
    }
}
