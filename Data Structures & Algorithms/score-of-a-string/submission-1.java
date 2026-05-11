class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length - 1; i ++) {
            sum += Math.abs((int) chars[i] - (int) chars[i + 1]);
        }
        return sum;
    }
}