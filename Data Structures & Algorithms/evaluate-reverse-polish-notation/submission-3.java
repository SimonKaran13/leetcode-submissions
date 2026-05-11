class Solution {

    Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String s : tokens) {
            switch (s) {
                case "+" -> {sum();}
                case "-" -> {subtract();}
                case "*" -> {mul();}
                case "/" -> {div();}
                default -> {push(s);}
            }
        }
        return stack.pop();
    }

    private void push(String s) {
        System.out.println("Push: " + s);
        stack.push(Integer.valueOf(s));
    }

    private void div() {
        int two = stack.pop();
        int one = stack.pop();
        int res = one / two;
        System.out.println("div " + one + ", " + two + " = " + res);
        stack.push(res);
    }

    private void mul() {
        int two = stack.pop();
        int one = stack.pop();
        int res = one * two;
        System.out.println("mul " + one + ", " + two + " = " + res);
        stack.push(res);
    }

    private void sum() {
        int two = stack.pop();
        int one = stack.pop();
        int res = one + two;
        System.out.println("add " + one + ", " + two + " = " + res);
        stack.push(res);
    }

    private void subtract() {
        int two = stack.pop();
        int one = stack.pop();
        int res = one - two;
        System.out.println("sub " + one + ", " + two + " = " + res);
        stack.push(res);
    }
}
