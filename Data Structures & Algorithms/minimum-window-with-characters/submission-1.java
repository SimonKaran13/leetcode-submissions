class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;

        Map<Character, Integer> tChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            tChars.put(c, tChars.getOrDefault(c, 0) + 1);
        }

        String result = "";
        while (r <= s.length()) {
            String subString = s.substring(l, r);
            if (containsAllChars(tChars, subString)) {
                if (result.equals("")) result = subString;
                else if (subString.length() < result.length()) {
                    result = subString;
                }
                l++;
            } else {
                r++;
            }
        }
        return result;
    }

    // Returns true if s contains all chars in the chars map
    private boolean containsAllChars(Map<Character, Integer> chars, String s) {
        Map<Character, Integer> sChars = new HashMap<>();
        for (char c : s.toCharArray()) {
            sChars.put(c, sChars.getOrDefault(c, 0) + 1);
        }

        for (var entry : chars.entrySet()) {
            char key = entry.getKey();
            int count = entry.getValue();

            if (!sChars.containsKey(key)) return false;
            if (sChars.get(key) < count) return false;

        }
        return true;
    }
}
