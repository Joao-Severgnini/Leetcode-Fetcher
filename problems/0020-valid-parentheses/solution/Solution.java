import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i); // Current character

            // If the stack is not empty, we can try to match the current character
            if (!stack.isEmpty()) {
                char last = stack.peek(); // Peek at the last opening bracket

                // Check if the last opening and current closing brackets match
                if (isPair(last, cur)) {
                    stack.pop(); // Remove the matched opening bracket from the stack
                    continue;    // Skip to next character
                }
            }

            // If no match was found or stack is empty, push the current character
            stack.push(cur);
        }

        // If the stack is empty, all brackets matched correctly
        return stack.isEmpty();
    }

    // Helper method to check if the pair of brackets match
    public boolean isPair(char last, char cur) {
        return (last == '(' && cur == ')') ||
               (last == '[' && cur == ']') ||
               (last == '{' && cur == '}');
    }
}
