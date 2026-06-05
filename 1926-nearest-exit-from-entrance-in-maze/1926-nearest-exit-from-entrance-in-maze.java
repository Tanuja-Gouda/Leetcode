class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{
                entrance[0],
                entrance[1],
                0
        });

        maze[entrance[0]][entrance[1]] = '+';

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            if ((row == 0 || col == 0 ||
                 row == m - 1 || col == n - 1) &&
                 !(row == entrance[0] &&
                   col == entrance[1])) {

                return steps;
            }

            for (int d = 0; d < 4; d++) {

                int newRow = row + dr[d];
                int newCol = col + dc[d];

                if (newRow >= 0 &&
                    newCol >= 0 &&
                    newRow < m &&
                    newCol < n &&
                    maze[newRow][newCol] == '.') {

                    maze[newRow][newCol] = '+';

                    q.offer(new int[]{
                            newRow,
                            newCol,
                            steps + 1
                    });
                }
            }
        }

        return -1;
    }
}