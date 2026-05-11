class Solution {
    private List<String> res = new ArrayList<>();
    private Stack<String> stack = new Stack<>();

    // We need n opening and n closing parenthesis.
    // Valid parenthesis always begin with an open parenthesis
    // When constructing a parethesis, there cannot be more closing parenthesis than opening
    public List<String> generateParenthesis(int n) {
        recursive(0, 0, n);
        return res;
    }

    private void recursive(int open, int close, int n) {
        if (open == close && open == n) {
            StringBuilder sb = new StringBuilder();
            for (String s : stack) {
                sb.append(s);
            }
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            stack.push("(");
            recursive(open + 1, close, n);
            stack.pop();
        }

        if (close < open) {
            stack.push(")");
            recursive(open, close + 1, n);
            stack.pop();
        }
    }
}
