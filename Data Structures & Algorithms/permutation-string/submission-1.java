class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> s1Chars = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int count = s1Chars.getOrDefault(c, 0);
            s1Chars.put(c, count + 1);
        }

        HashMap<Character, Integer> s2Chars = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            int count = s2Chars.getOrDefault(s2.charAt(i), 0);
            s2Chars.put(s2.charAt(i), count + 1);
        }

        if (s1Chars.equals(s2Chars)) return true;

        System.out.println(s2Chars);

        int l = 0;
        int r = s1.length() - 1;

        while (r < s2.length() - 1) {
            r++;
            char rChar = s2.charAt(r);
            int count = s2Chars.getOrDefault(rChar, 0);
            s2Chars.put(rChar, count + 1);

            char lChar = s2.charAt(l);
            if (s2Chars.get(lChar) == 1) {
                s2Chars.remove(lChar);
            } else {
                s2Chars.put(lChar, s2Chars.get(lChar) - 1);
            }
            l++;

            if (s1Chars.equals(s2Chars)) {
                return true;
            }

            System.out.println(s2Chars);
            System.out.println("---------");
            
        }

        return false;

    }
}