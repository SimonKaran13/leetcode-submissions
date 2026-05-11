class Solution {
    public int numDecodings(String s) {
        return recursive(s);
    }

    private int recursive(String s) {
        if (s.length() == 0) return 1;

        int one = valid(s.substring(0, 1)) ? recursive(s.substring(1, s.length())) : 0;

        if (s.length() >= 2) {
            int two = valid(s.substring(0, 2)) ? recursive(s.substring(2, s.length())) : 0;
            return one + two;
        }
        return one;
    }

    private boolean valid(String s) {
        if (s.charAt(0) == '0') return false;
        int val = Integer.valueOf(s);
        return val >= 1 && val <= 26;
    }
}
