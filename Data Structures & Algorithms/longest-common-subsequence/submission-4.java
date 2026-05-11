class Solution {
    private int[][] cache;

    public int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                cache[i][j] = -1;
            }
        }
        return dfs(text1, text2, 0, 0, cache);
    }

    private int dfs(String text1, String text2, int i, int j, int[][] cache) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        if (cache[i][j] != -1) return cache[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            int res = 1 + dfs(text1, text2, i + 1, j + 1, cache);
            cache[i][j] = res;
            return res;
        }
        int res = Math.max(dfs(text1, text2, i + 1, j, cache),
                        dfs(text1, text2, i, j + 1, cache));
        cache[i][j] = res;
        return res;
    }
}
