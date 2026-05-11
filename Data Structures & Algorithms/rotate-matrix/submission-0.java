class Solution {
    public void rotate(int[][] matrix) {
        int N = matrix.length;

        int L = 0;
        int R = N - 1;
        

        while (L < R) {
            for (int i = 0; i < R - L; i++) {
                int TOP = L;
                int BOTTOM = R;

                int topLeft = matrix[TOP][L + i];
                int topRight = matrix[TOP + i][R];
                int bottomLeft = matrix[BOTTOM - i][L];
                int bottomRight = matrix[BOTTOM][R - i];
                
                // Top Left = Bottom Left
                matrix[TOP][L + i] = bottomLeft;

                // Top Right = Top Left
                matrix[TOP + i][R] = topLeft;

                // Bottom Right = Top Right
                matrix[BOTTOM][R - i] = topRight;

                // Bottom Left = Bottom Right
                matrix[BOTTOM - i][L] = bottomRight;
            }
            R--;
            L++;
        }
    }
}
