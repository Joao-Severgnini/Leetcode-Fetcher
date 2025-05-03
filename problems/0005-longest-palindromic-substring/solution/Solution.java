class Solution {

    public String longestPalindrome(String s) {
        // Base case: if the string is null or has less than 2 characters, it's already a palindrome
        if (s == null || s.length() < 2) {
            return s;
        }

        // Variable to keep track of the longest palindrome found so far
        String longest = "";

        // Loop through each character in the string, treating it as the center of a potential palindrome
        for (int i = 0; i < s.length(); i++) {

            // Check for odd-length palindromes (centered at a single character)
            String odd = expandAroundCenter(s, i, i);
            if (odd.length() > longest.length()) {
                longest = odd;
            }

            // Check for even-length palindromes (centered between two characters)
            String even = expandAroundCenter(s, i, i + 1);
            if (even.length() > longest.length()) {
                longest = even;
            }
        }

        // Return the longest palindromic substring found
        return longest;
    }

    // Helper method that expands around the given center while the characters match
    private String expandAroundCenter(String s, int left, int right) {
        // Expand outwards as long as the characters are equal and within bounds
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }

        // When the loop ends, left and right are one step past the last matching characters
        // So we return the valid palindrome using substring(left + 1, right)
        // Note: substring excludes the character at index 'right'
        return s.substring(left + 1, right);
    }
}
