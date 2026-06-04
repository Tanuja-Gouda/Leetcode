class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] distance = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    distance[i][j] = -1;
                }
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            for (int d = 0; d < 4; d++) {

                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < m && newCol < n &&
                    distance[newRow][newCol] == -1) {

                    distance[newRow][newCol] =
                            distance[row][col] + 1;

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        return distance;
    }
}