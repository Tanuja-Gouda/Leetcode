class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {

        if (row < 0 || col < 0 ||
            row >= grid.length || col >= grid[0].length ||
            grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int area = 1;

        area += dfs(row + 1, col, grid); // Down
        area += dfs(row - 1, col, grid); // Up
        area += dfs(row, col + 1, grid); // Right
        area += dfs(row, col - 1, grid); // Left

        return area;
    }
}