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
