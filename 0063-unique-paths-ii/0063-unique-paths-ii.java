class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] cur=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0 && obstacleGrid[i][j] == 0){
                    cur[j]=1;
                }else if(obstacleGrid[i][j] == 1){
                    cur[j]=0;
                }else{
                    int right=0;
                    int bottom=0;
                    if(i>0) bottom=prev[j];
                    if(j>0) right=cur[j-1];
                    cur[j]=right+bottom;
                }
            }
            prev=cur;
        }
        return prev[n-1];
    }
}