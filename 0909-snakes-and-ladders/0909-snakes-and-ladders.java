class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.offer(1);
        visited[1] = true;

        int moves = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int curr = q.poll();

                if (curr == n * n) {
                    return moves;
                }

                for (int next = curr + 1;
                     next <= Math.min(curr + 6, n * n);
                     next++) {

                    int[] pos = getCoordinates(next, n);

                    int row = pos[0];
                    int col = pos[1];

                    int destination =
                            board[row][col] == -1
                            ? next
                            : board[row][col];

                    if (!visited[destination]) {

                        visited[destination] = true;
                        q.offer(destination);
                    }
                }
            }

            moves++;
        }

        return -1;
    }

    private int[] getCoordinates(int num, int n) {

        int row = (num - 1) / n;
        int col = (num - 1) % n;

        if (row % 2 == 1) {
            col = n - 1 - col;
        }

        row = n - 1 - row;

        return new int[]{row, col};
    }
}