import java.util.ArrayList;
import java.util.List;

class Solution {
    // The main method that generates all possible combinations of balanced parentheses
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>(); // List to store the valid parentheses combinations

        // Call the helper method dfs to perform a depth-first search (DFS)
        dfs(0, 0, "", n, res);
        return res; // Return the list of valid parentheses combinations
    }

    // Helper method to perform depth-first search and generate combinations of parentheses
    public void dfs(int openP, int closeP, String s, int n, List<String> res){
        // If the number of open and close parentheses is equal, and their total count is 2*n (balanced parentheses)
        if(openP == closeP && openP + closeP == n * 2){
            res.add(s); // Add the valid combination to the result list
            return; // Return because we’ve found a valid combination
        }

        // If the number of open parentheses is less than n, we can add another open parenthesis
        if(openP < n){
            dfs(openP + 1, closeP, s + "(", n, res); // Recurse with one more open parenthesis
        }

        // If the number of close parentheses is less than the number of open parentheses, we can add a close parenthesis
        if(closeP < openP){
            dfs(openP, closeP + 1, s + ")", n, res); // Recurse with one more close parenthesis
        }
    }
}
