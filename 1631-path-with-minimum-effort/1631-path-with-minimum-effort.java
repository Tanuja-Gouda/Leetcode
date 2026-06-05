class Solution {

    public int minimumEffortPath(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        int[][] effort = new int[m][n];

        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, 0, 0});
        effort[0][0] = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int currEffort = curr[0];
            int row = curr[1];
            int col = curr[2];

            if (row == m - 1 &&
                col == n - 1) {
                return currEffort;
            }

            for (int d = 0; d < 4; d++) {

                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if (newRow >= 0 &&
                    newCol >= 0 &&
                    newRow < m &&
                    newCol < n) {

                    int diff =
                            Math.abs(
                                    heights[row][col]
                                    - heights[newRow][newCol]);

                    int newEffort =
                            Math.max(currEffort,
                                     diff);

                    if (newEffort
                            < effort[newRow][newCol]) {

                        effort[newRow][newCol]
                                = newEffort;

                        pq.offer(
                                new int[]{
                                        newEffort,
                                        newRow,
                                        newCol
                                });
                    }
                }
            }
        }

        return 0;
    }
}