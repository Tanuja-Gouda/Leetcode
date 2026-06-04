class Solution {
    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // First and Last Column
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, board);
            }

            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1, board);
            }
        }

        // First and Last Row
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, board);
            }

            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j, board);
            }
        }

        // Convert remaining O -> X
        // Convert # -> O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board) {

        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != 'O') {
            return;
        }

        board[row][col] = '#';

        dfs(row + 1, col, board); // Down
        dfs(row - 1, col, board); // Up
        dfs(row, col + 1, board); // Right
        dfs(row, col - 1, board); // Left
    }
}
    