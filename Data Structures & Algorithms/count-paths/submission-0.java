class Solution {
    public int uniquePaths(int m, int n) {
        int[][] numPaths = new int[m][];
        for (int i = 0; i < m; i++) {
            numPaths[i] = new int[n];
            numPaths[i][n - 1] = 1;
            if (i == m - 1) {
                Arrays.fill(numPaths[i], 1);
            }
        }


        for (int ROW = m - 2; ROW >= 0; ROW--) {
            for (int COL = n - 2; COL >= 0; COL--) {
                numPaths[ROW][COL] = numPaths[ROW][COL + 1] + numPaths[ROW + 1][COL];
            } 
        }

        return numPaths[0][0];
    }
}
