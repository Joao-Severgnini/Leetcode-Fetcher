import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> letterCombinations(String digits) {
        // Result list to store all valid combinations
        List<String> res = new ArrayList<>();

        // If input is null or empty, return empty result
        if (digits == null || digits.length() == 0) {
            return res;
        }

        // Map digits to their corresponding letters (like on a phone keypad)
        Map<Character, String> digitsToLetters = new HashMap<>();
        digitsToLetters.put('2', "abc");
        digitsToLetters.put('3', "def");
        digitsToLetters.put('4', "ghi");
        digitsToLetters.put('5', "jkl");
        digitsToLetters.put('6', "mno");
        digitsToLetters.put('7', "pqrs");
        digitsToLetters.put('8', "tuv");
        digitsToLetters.put('9', "wxyz");

        // Start backtracking to build all combinations
        backtrack(digits, 0, new StringBuilder(), res, digitsToLetters);

        return res;
    }

    // Helper function for backtracking
    private void backtrack(String digits, int idx, StringBuilder comb,
                           List<String> res, Map<Character, String> digitsToLetters) {

        // Base case: if the current combination length matches the input digits length
        if (idx == digits.length()) {
            res.add(comb.toString());
            return;
        }

        // Get the possible letters for the current digit
        String letters = digitsToLetters.get(digits.charAt(idx));

        // Iterate over each letter and recurse
        for (char letter : letters.toCharArray()) {
            comb.append(letter); // Choose
            backtrack(digits, idx + 1, comb, res, digitsToLetters); // Explore
            comb.deleteCharAt(comb.length() - 1); // Un-choose (backtrack)
        }
    }
}
