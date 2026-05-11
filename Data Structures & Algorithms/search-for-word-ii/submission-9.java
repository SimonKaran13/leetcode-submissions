class Solution {
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree trie = new PrefixTree();
        
        for (String word : words) {
            trie.insert(word);
        }


        for (int ROW = 0; ROW < board.length; ROW++) {
            for (int COL = 0; COL < board[0].length; COL++) {
                dfs(ROW, COL, board, trie, "", new HashSet<>());
            }
        }

        List<String> resList = new ArrayList<>(res);
        return resList;
    }

    private void dfs(int row, int col, char[][] board, PrefixTree trie, String current, HashSet<List<Integer>> visited) {
        if (row >= board.length || row < 0) return;
        if (col >= board[0].length || col < 0) return;
        if (visited.contains(List.of(row, col))) {
            return;
        }
    
        StringBuilder sb = new StringBuilder();
        sb.append(current);
        sb.append(board[row][col]);
        String s = sb.toString();

        if (!trie.startsWith(s)) {
            return;
        }

        
        if (trie.search(s)) {
            res.add(s);
        }

        visited.add(List.of(row, col));
        dfs(row + 1, col, board, trie, s, visited);
        dfs(row - 1, col, board, trie, s, visited);
        dfs(row, col + 1, board, trie, s, visited);
        dfs(row, col - 1, board, trie, s, visited);
        visited.remove(List.of(row, col));
    }
}

class PrefixTree {

    private TreeNode root; 

    public PrefixTree() {
        this.root = new TreeNode();         
    }

    public void insert(String word) {
        TreeNode current = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TreeNode());
            }
            current = current.children.get(c);
        }
        current.word = true;
    }

    public boolean search(String word) {
        TreeNode current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return current.word;
    }

    public boolean startsWith(String prefix) {
        TreeNode current = root;
        for (char c : prefix.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return true;
    }
}

class TreeNode {

    private Map<Character, TreeNode> children;
    private boolean word;

    public TreeNode() {
        this.children = new HashMap<>();
        this.word = false;
    }

}
