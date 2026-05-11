class Solution {
    public boolean isValidSudoku(char[][] board) {
        // First check rows
        for (int row = 0; row < 9; row++) {
            Set<Character> nums = new HashSet<>();
            for (int column = 0; column < 9; column++) {
                char value = board[row][column];
                if (value == '.') continue;
                else if (nums.contains(value)) return false;
                else nums.add(value);
            }
        }

        // Second columns rows
        for (int column = 0; column < 9; column++) {
            Set<Character> nums = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char value = board[row][column];
                if (value == '.') continue;
                else if (nums.contains(value)) return false;
                else nums.add(value);
            }
        }

        // Third check squares
        for (int sqRow = 0; sqRow < 3; sqRow++) {
            for (int sqColumn = 0; sqColumn < 3; sqColumn++) {
                Set<Character> nums = new HashSet<>();
                for (int row = 0; row < 3; row++) {
                    for (int column = 0; column < 3; column++) {
                        char value = board[row + 3 * sqRow][column + 3 * sqColumn];
                        if (value == '.') continue;
                        else if (nums.contains(value)) return false;
                        else nums.add(value);
                    }
                }
            }
        }

        return true;
    }
}
