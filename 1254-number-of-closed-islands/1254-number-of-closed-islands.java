class Solution {

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Remove islands connected to boundary
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 0) {
                dfs(i, 0, grid);
            }

            if (grid[i][n - 1] == 0) {
                dfs(i, n - 1, grid);
            }
        }

        for (int j = 0; j < n; j++) {

            if (grid[0][j] == 0) {
                dfs(0, j, grid);
            }

            if (grid[m - 1][j] == 0) {
                dfs(m - 1, j, grid);
            }
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 0) {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int row, int col, int[][] grid) {

        if (row < 0 || col < 0 ||
            row >= grid.length ||
            col >= grid[0].length ||
            grid[row][col] == 1) {
            return;
        }

        grid[row][col] = 1;

        dfs(row + 1, col, grid); // Down
        dfs(row - 1, col, grid); // Up
        dfs(row, col + 1, grid); // Right
        dfs(row, col - 1, grid); // Left
    }
}