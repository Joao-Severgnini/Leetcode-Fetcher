class Solution {
    public String multiply(String num1, String num2) {
        // If either number is zero, the result is zero
        if(num1.equals("0") || num2.equals("0")) return "0";

        // Create an array to hold the result digits
        int[] ans = new int[num1.length() + num2.length()];

        // We multiply each digit of num1 by each digit of num2 (like on paper)
        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){

                // We calculate the positions in the result array
                int valueIdx = i + j + 1;       // where to put the current digit
                int remainderIdx = i + j;       // where to carry the overflow

                // Multiply digits (converted from characters to integers)
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // Add any value already in that position
                product += ans[valueIdx];

                // Store the single digit at valueIdx
                ans[valueIdx] = product % 10;

                // Carry the tens to remainderIdx
                ans[remainderIdx] += product / 10;
            }
        }

        // Build the final string result, skipping leading zeros
        boolean precedingZeros = true;
        StringBuilder result = new StringBuilder();

        for(int i = 0; i < ans.length; i++){
            int value = ans[i];
            if(value != 0) precedingZeros = false;
            if(!precedingZeros) result.append(value);
        }

        return result.toString();
    }
}
