class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t)) return true;
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> charactersS = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charactersS.containsKey(c)) {
                int count = charactersS.get(c);
                charactersS.put(c, count + 1);
            } else {
                charactersS.put(c, 1);
            }
        }

        Map<Character, Integer> charactersT = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (charactersT.containsKey(c)) {
                int count = charactersT.get(c);
                charactersT.put(c, count + 1);
            } else {
                charactersT.put(c, 1);
            }
        }

        if (!charactersS.keySet().equals(charactersT.keySet())) return false;

        for (Character key : charactersS.keySet()) {
            int countS = charactersS.get(key);
            int countT = charactersT.get(key);
            if (countS != countT) {
                return false;
            }
        }

        return true;
    }
}
