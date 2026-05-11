class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        for (int ROW = 0; ROW < heights.length; ROW++) {
            for (int COL = 0; COL < heights[0].length; COL++) {
                if (bfs(heights, ROW, COL)) {
                    res.add(List.of(ROW, COL));
                }
            }
        }
        return res;
    }

    private boolean bfs(int[][] heights, int row, int col) {
        Queue<List<Integer>> q = new LinkedList<>();
        Set<List<Integer>> visited = new HashSet<>();

        q.add(List.of(row, col));

        boolean foundPacific = false;
        boolean foundAtlantic = false;

        while (!q.isEmpty()) {
            if (foundPacific && foundAtlantic) return true;

            List<Integer> coords = q.poll();
            if (visited.contains(coords)) {
                    continue;
                }
            visited.add(coords);
            
            int curRow = coords.get(0);
            int curCol = coords.get(1);

            if (isPacific(heights, curRow, curCol)) {
                foundPacific = true;    
            }
            if (isAtlantic(heights, curRow, curCol)) {
                foundAtlantic = true;
            }

            int height = heights[curRow][curCol];

            // left
            if (curCol - 1 >= 0 
            && heights[curRow][curCol - 1] <= height) {
                q.add(List.of(curRow, curCol - 1));
            }

            // right
            if (curCol + 1 <= heights[0].length - 1 
            && heights[curRow][curCol + 1] <= height) {
                q.add(List.of(curRow, curCol + 1));
            }

            // up
            if (curRow - 1 >= 0 
            && heights[curRow - 1][curCol] <= height) {
                q.add(List.of(curRow - 1, curCol));
            }

            // down
            if (curRow + 1 <= heights.length - 1 
            && heights[curRow + 1][curCol] <= height) {
                q.add(List.of(curRow + 1, curCol));
            }
            
        }
        return foundPacific && foundAtlantic;
    }

    private boolean isPacific(int[][] heights, int row, int col) {
        if (row == 0 || col == 0) return true;
        else return false;
    }

    private boolean isAtlantic(int[][] heights, int row, int col) {
        if (row == heights.length - 1 || col == heights[0].length - 1) return true;
        else return false;
    }
}
