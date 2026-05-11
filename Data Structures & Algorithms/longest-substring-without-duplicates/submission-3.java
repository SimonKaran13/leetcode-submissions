class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();

        Set<Character> window = new HashSet<>();
        int longestLength = 0;
        int left = 0;
        int right = 0;
        while (left < s.length() && right < s.length()) {
            if (!window.contains(chars[right])) {
                window.add(chars[right]);
                right++;
            } else {
                window.remove(chars[left]);
                left++;
            }
            longestLength = Math.max(longestLength, window.size());
        }

        return longestLength;
        
    }
}
