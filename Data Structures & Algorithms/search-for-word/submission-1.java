class Solution {
    public boolean exist(char[][] board, String word) {
        char[] letters = word.toCharArray();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (letters[0] == board[i][j]) {
                    Set<List<Integer>> visited = new HashSet<>();
                    boolean found = find(board, i, j, letters, 0, visited);
                    if (found) return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, int i, int j, char[] letters, int currentLetter, Set<List<Integer>> visited) {
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;

        List<Integer> coords = List.of(i, j);
        if (visited.contains(coords)) {
             return false;
        }
        visited.add(coords);
 
        if (board[i][j] == letters[currentLetter]) {
            if (currentLetter == letters.length - 1) return true;

            Set<List<Integer>> visitedCopy = new HashSet<>(visited);
            boolean left = find(board, i, j - 1, letters, currentLetter + 1, visitedCopy);

            visitedCopy = new HashSet<>(visited);
            boolean right = find(board, i, j + 1, letters, currentLetter + 1, visitedCopy);

            visitedCopy = new HashSet<>(visited);
            boolean up = find(board, i - 1, j, letters, currentLetter + 1, visitedCopy);

            visitedCopy = new HashSet<>(visited);
            boolean down = find(board, i + 1, j, letters, currentLetter + 1, visitedCopy);

            return left || right || up || down;
            
        } else {
            return false;
        }
    }
}
