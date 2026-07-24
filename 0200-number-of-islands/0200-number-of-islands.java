class Solution {
    
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] vis=new boolean[m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    count += 1;
                    findIsland(i,j,grid,vis);
                }
            }
        }
        return count;
    }

    private void findIsland(int i,int j,char[][] grid, boolean[][] vis){
        vis[i][j]=true;
        int[] dr={0,1,0,-1};
        int[] dc={-1,0,1,0};
        int m=grid.length;
        int n=grid[0].length;
        for(int k=0;k<4;k++){
            int r=i+dr[k];
            int c=j+dc[k];
            if(r>=0 && r<m && c>=0 && c<n && grid[r][c]=='1' && vis[r][c]==false){
                findIsland(r,c,grid,vis);
            }
        }
    }
}

