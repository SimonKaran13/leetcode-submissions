class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Chars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int count = s1Chars.getOrDefault(c, 0);
            s1Chars.put(c, count + 1);
        }

        int l = 0;
        int r = s1.length();

        while (r <= s2.length()) {
            if (isPermutation(s1Chars, s2.substring(l, r))) {
                return true;
            }
            l++;
            r++;
        }

        return false;

    }

    private boolean isPermutation(Map<Character, Integer> s1Chars, String s) {
        HashMap<Character, Integer> sChars = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = sChars.getOrDefault(c, 0);
            sChars.put(c, count + 1);
        }
        return s1Chars.equals(sChars);
    }
}
