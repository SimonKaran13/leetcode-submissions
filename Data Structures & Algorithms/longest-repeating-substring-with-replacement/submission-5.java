class Solution {
    public int characterReplacement(String s, int k) {
        // "ABCDEFGAAA" k = 5, max = 3
        // "AACDEFGAAA" K = 4, max = 3
        // "AAADEFGAAA" k = 3, max = 3
        // "AAAAEFGAAA" k = 2, max = 4
        // "AAAAAFGAAA" k = 1, max = 5
        // "AAAAAAGAAA" k = 0, max = 6
        // ""

        // "ABACADAEAFAG"
        // 26 English Characters
        // HashMap to count ocurrances of characters in each substring.

        int l = 0;
        int r = 0;
        int result = 0;
        Map<Character, Integer> charsInWindow = new HashMap<>();
        char[] chars = s.toCharArray();
        char mostFrequentChar = chars[l];
        int windowLen = 0;
        while (r < chars.length) {
            // Update count of chars in window
            charsInWindow.put(chars[r], charsInWindow.getOrDefault(chars[r], 0) + 1);
            // Update most frequent Char in window
            mostFrequentChar = getMostFrequentChar(charsInWindow);

            windowLen++;
            // Check if window is valid
            while (windowLen - charsInWindow.get(mostFrequentChar) > k) {
                // shrink left until it is valid
                charsInWindow.put(chars[l], charsInWindow.get(chars[l]) - 1);
                l++;
                mostFrequentChar = getMostFrequentChar(charsInWindow);
                windowLen--;
            }
            
            result = Math.max(result, windowLen);
            r++;
        }
        return result;
        
    }

    private char getMostFrequentChar(Map<Character, Integer> charsInWindow) {
        char mostFrequentChar = '#';
        int frequency = 0;
        for (char key : charsInWindow.keySet()) {
            if (charsInWindow.get(key) > frequency) {
               mostFrequentChar = key;
               frequency = charsInWindow.get(key);
            }
        }
        return mostFrequentChar;
    }
}
