class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int result = 0;
        int left = 0;
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (!frequencies.containsKey(c)) {
                frequencies.put(c, 1);
            } else {
                frequencies.compute(c, (key, val) -> val + 1);
            }

            while (frequencies.size() > k) {
                c = s.charAt(left);
                frequencies.computeIfPresent(c, (key, value) -> value > 1 ? value - 1 : null);
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
