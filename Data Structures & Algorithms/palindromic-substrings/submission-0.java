class Solution {
    public int countSubstrings(String s) {

        // Base Case 1 - palindromes of length 1
        boolean[][] dp = new boolean[s.length()][];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = new boolean[s.length()];
            dp[i][i] = true;
        }

        int res = s.length(); // start at palindromes length 1

        // Base Case 2 - length 2
        for(int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
            if (dp[i][i + 1]) {
                res++;
            }
        }

        // Length > 2
        for (int len = 3; len <= s.length(); len++) {
            for (int start = 0; start + len - 1 < s.length(); start++) {
                dp[start][start + len - 1] = dp[start + 1][start + len - 2] && s.charAt(start) == s.charAt(start + len - 1);
                if (dp[start][start + len - 1]) {
                    res++;
                }
            }

        }

        return res;
    }
}
