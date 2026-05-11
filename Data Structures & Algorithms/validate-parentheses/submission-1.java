class Solution {
    public boolean isValid(String s) {
        // Assumption: s has only parentheses characters
        // ({([[]])})
        // ([[[[[[{{
        // ({)}
        // }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // c is a closing parentheses
            else if (stack.isEmpty()) {
                return false; // No matching opening parentheses
            }
            else if (c == ')') {
                char topMost = stack.pop();
                if (topMost != '(') {
                    return false;
                }
            }
            else if (c == '}') {
                char topMost = stack.pop();
                if (topMost != '{') {
                    return false;
                }
            }
            else if (c == ']') {
                char topMost = stack.pop();
                if (topMost != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
