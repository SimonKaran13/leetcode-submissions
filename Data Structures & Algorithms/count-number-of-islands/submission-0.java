class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int ROW = 0; ROW < grid.length; ROW++) {
            for (int COL = 0; COL < grid[0].length; COL++) {
                if (grid[ROW][COL] == '1') {
                    res++;
                    exploreIsland(grid, ROW, COL, new HashSet<>());
                }
            }
        }
        return res;
    }

    private void exploreIsland(char[][] grid, int ROW, int COL,  Set<List<Integer>> visited) {
        if (ROW < 0 || ROW >= grid.length || COL < 0 || COL >= grid[0].length) return;
        if (grid[ROW][COL] == '0') return;
        
        if (visited.contains(List.of(ROW, COL))) {
            return;
        } else {
            visited.add(List.of(ROW, COL));
        }

        exploreIsland(grid, ROW, COL + 1, visited);
        exploreIsland(grid, ROW, COL - 1, visited);
        exploreIsland(grid, ROW + 1, COL, visited);
        exploreIsland(grid, ROW - 1, COL, visited);

        grid[ROW][COL] = '0';
    }
}
