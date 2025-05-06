class Solution {
    public boolean isMatch(String s, String p) {
        // Create a memoization table to store results of subproblems.
        // memo[i][j] means: does s[i:] match p[j:]?
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return dp(0, 0, s, p, memo);
    }

    private boolean dp(int i, int j, String s, String p, Boolean[][] memo) {

        // If the result is already computed, return it.
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean res;

        // If we've reached the end of the pattern, return true only if
        // we've also reached the end of the string.
        if (j == p.length()) {
            res = (i == s.length());
        } else {
            // Check if the current characters match.
            // Note: we must ensure i < s.length() before accessing s.charAt(i).
            boolean match = (i < s.length() && 
                            (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.'));

            // If the next character in the pattern is '*', we have two choices:
            // 1. Skip 'x*' (i.e., move to j + 2)
            // 2. If current characters match, consume one char from s and try again with the same pattern.
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                res = dp(i, j + 2, s, p, memo) || 
                      (match && dp(i + 1, j, s, p, memo));
            } else {
                // If there's no '*', just check current match and move both indices forward.
                res = match && dp(i + 1, j + 1, s, p, memo);
            }
        }

        // Store the result before returning.
        memo[i][j] = res;
        return res;
    }
}
