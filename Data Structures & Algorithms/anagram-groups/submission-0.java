class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            Integer[] key = new Integer[26];
            for (char c : str.toCharArray()) {
                int count = Objects.requireNonNullElse(key[c - 'a'], 0);
                key[c - 'a'] = count + 1;
            }
            List<Integer> actualKey = Arrays.asList(key);
            if (result.containsKey(actualKey)) {
                result.get(actualKey).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                result.put(actualKey, list);
            }
        }
        return result.entrySet().stream().map(x -> x.getValue()).toList();
    }
}
