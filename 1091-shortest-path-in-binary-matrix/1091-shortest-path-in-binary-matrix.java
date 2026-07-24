class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;

        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }         

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0]=1;

        // int[] nr={-1,0,1};
        // int[] nc={-1,0,1};

        int[] nr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] nc = {-1, 0, 1, -1, 1, -1, 0, 1};


        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];
            int dist=cur[2];

            if(r==n-1 && c==n-1){
                return dist;
            }

            for(int i=0;i<8;i++){
                    int nrr=r+nr[i];
                    int ncc=c+nc[i];
                    if(nrr>=0 && ncc>=0 && nrr<n && ncc<n && grid[nrr][ncc]==0){
                        grid[nrr][ncc]=1;
                        q.offer(new int[]{nrr,ncc,dist+1});
                    }
            }
        }
        return -1;
    }
}























// int n = grid.length;

//         if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
//             return -1;
//         }

//         Queue<int[]> q = new LinkedList<>();

//         q.offer(new int[]{0, 0, 1});
//         grid[0][0] = 1;

//         int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
//         int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

//         while (!q.isEmpty()) {

//             int[] curr = q.poll();

//             int row = curr[0];
//             int col = curr[1];
//             int distance = curr[2];

//             if (row == n - 1 && col == n - 1) {
//                 return distance;
//             }

//             for (int d = 0; d < 8; d++) {

//                 int newRow = row + dr[d];
//                 int newCol = col + dc[d];

//                 if (newRow >= 0 &&
//                     newCol >= 0 &&
//                     newRow < n &&
//                     newCol < n &&
//                     grid[newRow][newCol] == 0) {

//                     grid[newRow][newCol] = 1;

//                     q.offer(new int[]{
//                             newRow,
//                             newCol,
//                             distance + 1
//                     });
//                 }
//             }
//         }

//         return -1;