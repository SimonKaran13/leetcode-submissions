class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // TOP DOWN + MEMOIZATION
        // HashMap<String, Boolean> cache = new HashMap<>();
        // for (String word : wordDict) {
        //     cache.put(word, true); // Base Cases
        // }
        // return recursive(s, wordDict, cache);

        return bottomUp(s, wordDict);
    }

    private boolean bottomUp(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length()];
        outer:
        for (int i = s.length() - 1; i >= 0; i--) {
            String subString = s.substring(i);
            for (String word : wordDict) {
                if (word.equals(subString)) { // Check if Substring is a word
                    cache[i] = true; 
                    continue outer;
                }
            }
            for (int j = i + 1; j < s.length(); j++) { // Check previous substrings
                if (cache[j]) {
                    String subSubstring = s.substring(i, j);
                    for (String word : wordDict) {
                        if (word.equals(subSubstring)) {
                            cache[i] = true; 
                            continue outer;
                        }
                    }
                }
            }
            cache[i] = false;
        }
        return cache[0];
    }


    public boolean recursive(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String subString = s.substring(word.length());
                if (recursive(subString, wordDict, cache)) {
                    cache.put(subString, true);
                    return true;
                } 
            }
        }
        cache.put(s, false);
        return false;
    }
}
