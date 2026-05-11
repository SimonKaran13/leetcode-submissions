class Solution {
    public String longestPalindrome(String s) {
        boolean[][] cache = new boolean[s.length()][];
        
        // Base Case -> Length 1 -> O(n)
        for (int i = 0; i < s.length(); i++) {
            cache[i] = new boolean[s.length()];
            cache[i][i] = true; // substring starting at i and ending at i is a palindrome (length 1)
        }

        char[] chars = s.toCharArray();

        int longestLen = 1;
        int longestStart = 0;
        int longestEnd = 0;
        // Base Case -> Length 2 -> O(n)
        for (int i = 0; i < s.length() - 1; i++) {
            cache[i][i + 1] = (chars[i] == chars[i + 1]);
            if (cache[i][i + 1]) {
                longestStart = i;
                longestEnd = i + 1;
                longestLen = 2;
            }
        }

        // Bottom Up + Memoization
        
        for(int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                int end = start + length;
                cache[start][end] = (chars[start] == chars[end]) && cache[start + 1][end - 1];
                if (cache[start][end] && length + 1 > longestLen) {
                    longestStart = start;
                    longestEnd = end;
                    longestLen = length + 1;
                }
            }
        }
        return s.substring(longestStart, longestEnd + 1);
    }
}
