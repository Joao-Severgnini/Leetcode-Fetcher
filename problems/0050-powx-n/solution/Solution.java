public class Solution {
    // Public method that handles both positive and negative exponents
    public double myPow(double x, int n) {
        double res = helper(x, Math.abs(n));  // Compute power using absolute value of exponent
        return (n < 0) ? 1 / res : res;       // If exponent was negative, return reciprocal
    }

    // Recursive helper function using exponentiation by squaring
    private double helper(double x, int n) {
        if (x == 0) return 0;        // Base case: 0^n = 0
        if (n == 0) return 1;        // Base case: x^0 = 1

        double res = helper(x, n / 2);  // Recursive call: reduce exponent by half
        res = res * res;               // Square the result (x^(n/2))^2

        // If exponent is odd, multiply by x once more
        return (n % 2 == 0) ? res : x * res;
    }
    // Main method for testing
}
