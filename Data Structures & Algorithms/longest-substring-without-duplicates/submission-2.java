class Solution {
    // "zxyzxyz"
    // "au"
    // "dvdf"
    // Sliding Window -> sub array without duplicates O(n) time and O(n) space

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int l = 0;
        int result = 0;

        for (int r = 0; r < chars.length; r++) {
            while (set.contains(chars[r])) {
                set.remove(chars[l]);
                l++;
            }
            set.add(chars[r]);
            result = Math.max(result, r - l + 1);
        }
        return result;
    }
}
