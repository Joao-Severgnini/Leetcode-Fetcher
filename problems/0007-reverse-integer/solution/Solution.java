class Solution {
    public int reverse(int x) {
        // Convert the input integer to a long to safely handle overflow during reversal
        long longNum = x;

        // This will hold the reversed number
        long reversedNum = 0;

        // Loop until all digits have been reversed
        while (longNum != 0) {
            // Take the last digit and add it to the reversed number (shifted by one place)
            reversedNum = reversedNum * 10 + longNum % 10;

            // Remove the last digit from the original number
            longNum /= 10;
        }

        // Check for 32-bit signed integer overflow
        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE) {
            return 0; // Return 0 if it overflows
        }

        // Return the reversed number cast back to int
        return (int) reversedNum;
    }
}
