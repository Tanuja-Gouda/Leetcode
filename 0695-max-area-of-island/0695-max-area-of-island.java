class Solution {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int max=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid));
                }
            }
        }
        return max;
    }

    public int dfs(int row,int col,int[][] grid){
        if(row<0 || col<0 || row>grid.length-1 || col>grid[0].length-1 || grid[row][col]==0){
            return 0;
        }

        grid[row][col]=0;

        int ans=1;
        int[] dr={0,1,0,-1};
        int[] dc={-1,0,1,0};

        for(int i=0;i<4;i++){
            int r=row+dr[i];
            int c=col+dc[i];

            ans += dfs(r,c,grid);
        }
        return ans;
    }
}

