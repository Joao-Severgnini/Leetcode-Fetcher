public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // Sample test cases
        System.out.println(sol.myPow(2.0, 10));   // Expected: 1024.0
        System.out.println(sol.myPow(2.1, 3));    // Expected: ~9.261
        System.out.println(sol.myPow(2.0, -2));   // Expected: 0.25
        System.out.println(sol.myPow(0, 5));      // Expected: 0.0
        System.out.println(sol.myPow(5, 0));      // Expected: 1.0
    }
}
