class Solution {
    public String foreignDictionary(String[] words) {
        HashMap<Character, Set<Character>> adjacencyList = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacencyList.put(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) return "";

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adjacencyList.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        HashMap<Character, Boolean> visited = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (char c : adjacencyList.keySet()) {
            if (dfs(c, visited, adjacencyList, res)) return ""; 
        }

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for (char c : res) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean dfs(char c, HashMap<Character, Boolean> visited, HashMap<Character, Set<Character>> adjacencyList, List<Character> res) {
        if (visited.containsKey(c)) {
            return visited.get(c);
        }

        visited.put(c, true);

        for (char neigh : adjacencyList.get(c)) {
            if (dfs(neigh, visited, adjacencyList, res)) return true;
        }

        visited.put(c, false);

        res.add(c);
        return false;
    }
}
