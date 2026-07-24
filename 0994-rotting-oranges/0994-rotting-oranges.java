class Solution {

    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int fresh=0;

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j,0});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int time=0;
        while(!q.isEmpty()){
            int[] cur=q.peek();
            q.remove();
            int r=cur[0];
            int c=cur[1];
            int tm=cur[2];
            time=Math.max(time,tm);

            int[] dr={0,1,0,-1};
            int[] dc={-1,0,1,0};

            for(int i=0;i<4;i++){
                int curR=r+dr[i];
                int curC=c+dc[i];
                if(curR>=0 && curC>=0 && curR<m && curC<n && grid[curR][curC]==1){
                    fresh--;
                    grid[curR][curC]=2;
                    q.offer(new int[]{curR,curC,tm+1});
                }
            }
        }
        return fresh==0 ? time :-1;
    }
}




























//  Queue<int[]> q = new LinkedList<>();
//         int fresh = 0;

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {

//                 if (grid[i][j] == 2) {
//                     q.offer(new int[]{i, j});
//                 } else if (grid[i][j] == 1) {
//                     fresh++;
//                 }
//             }
//         }

//         if (fresh == 0) {
//             return 0;
//         }

//         int minutes = 0;

        // int[] dr = {-1, 1, 0, 0};
        // int[] dc = {0, 0, -1, 1};

        // while (!q.isEmpty()) {

        //     int size = q.size();
        //     boolean rottenThisMinute = false;

        //     for (int i = 0; i < size; i++) {

        //         int[] curr = q.poll();
        //         int row = curr[0];
        //         int col = curr[1];

        //         for (int d = 0; d < 4; d++) {

        //             int newRow = row + dr[d];
        //             int newCol = col + dc[d];

        //             if (newRow >= 0 && newCol >= 0 &&
        //                 newRow < grid.length &&
        //                 newCol < grid[0].length &&
        //                 grid[newRow][newCol] == 1) {

        //                 grid[newRow][newCol] = 2;
        //                 fresh--;
        //                 q.offer(new int[]{newRow, newCol});
        //                 rottenThisMinute = true;
        //             }
        //         }
        //     }

        //     if (rottenThisMinute) {
        //         minutes++;
        //     }
        // }

        // return fresh == 0 ? minutes : -1;