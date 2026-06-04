class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: Top Row + Left Column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);
            dfs(i, n - 1, heights, atlantic);
        }

        // Atlantic: Bottom Row + Right Column
        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);
            dfs(m - 1, j, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col,
                     int[][] heights,
                     boolean[][] visited) {

        visited[row][col] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {

            int newRow = row + dr[d];
            int newCol = col + dc[d];

            if (newRow >= 0 && newCol >= 0 &&
                newRow < heights.length &&
                newCol < heights[0].length &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {

                dfs(newRow, newCol, heights, visited);
            }
        }
    }
}