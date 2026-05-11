class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Boolean> cache = new HashMap<>();
        for (String word : wordDict) {
            cache.put(word, true); // Base Cases
        }
        return recursive(s, wordDict, cache);
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
