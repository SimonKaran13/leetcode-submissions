class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.getChildren().containsKey(c)) {
                System.out.println("Put: " + c);
                current.getChildren().put(c, new TrieNode());
            }
            current = current.getChildren().get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return recSearch(word, root);
    }

    private boolean recSearch(String word, TrieNode current) {
        System.out.println("Searching word: " + word);
        if (word.equals("")) return current.isWord;

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            System.out.println("Char: " + c);
            if (c == '.') {
                for (var childEntry : current.getChildren().entrySet()) {
                    System.out.println("Searcing beginning char: " + childEntry.getKey());
                    if (recSearch(word.substring(i + 1), childEntry.getValue())) return true;
                }
                return false;
            }
            if (!current.getChildren().containsKey(c)) {
                System.out.println("Doesn't contain key");
                return false;
            }

            current = current.getChildren().get(c);
        }
        return current.isWord;
    }
}

class TrieNode {

    private Map<Character, TrieNode> children = new HashMap<>();  

    public boolean isWord = false;

    public Map<Character, TrieNode> getChildren() {
        return children;
    }
}


