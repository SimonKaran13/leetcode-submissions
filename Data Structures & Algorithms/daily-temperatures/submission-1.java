class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
 outer: for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int idx = stack.peek();
                if (temperatures[idx] > temperatures[i]) {
                    result[i] = idx - i;
                    stack.push(i);
                    continue outer;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
            result[i] = 0;
        }
        return result;
    }

    private int[] bruteForce(int[] temperatures) {
        int[] result = new int[temperatures.length];
outer:  for (int i = 0; i < temperatures.length; i++) {
            for (int j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j - i;
                    continue outer;
                }
            }
            result[i] = 0;
        }

        return result;
    }
}
