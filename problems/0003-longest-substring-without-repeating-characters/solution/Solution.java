import java.util.ArrayList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // List to store the current substring without repeating characters
        ArrayList<Character> curr = new ArrayList<>();
        
        // Variable to keep track of the length of the longest substring found
        int longest = 0;

        // Loop through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is not already in the current substring, add it
            if (!curr.contains(c)) {
                curr.add(c);
            } else {
                // If a duplicate character is found, update longest if needed
                longest = Math.max(curr.size(), longest);

                // Clear the current substring and start a new one with the current character
                curr.clear();
                curr.add(c);
            }
        }

        // Final check in case the longest substring is at the end of the input
        longest = Math.max(curr.size(), longest);

        return longest;
    }
}
