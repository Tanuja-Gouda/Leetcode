class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] cur=new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    cur[j]=grid[i][j];
                }else{
                    int right=Integer.MAX_VALUE;
                    int bottom=Integer.MAX_VALUE;
                    if(i>0) bottom = prev[j];
                    if(j>0) right = cur[j-1];
                    cur[j]=grid[i][j] + Math.min(bottom,right);
                }
            }
            prev=cur;
        }
        return prev[n-1];
    }
}