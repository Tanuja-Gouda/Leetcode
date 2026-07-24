class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;

        int[][] distance=new int[m][n];
        for(int i=0;i<m;i++){
        Arrays.fill(distance[i],-1);
        }

        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    distance[i][j]=0;
                    q.offer(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur=q.peek();
            q.remove();
            int r=cur[0];
            int c=cur[1];

            int[] dr={0,1,0,-1};
            int[] dc={-1,0,1,0};

            for(int i=0;i<4;i++){
                int curR=r+dr[i];
                int curC=c+dc[i];
                if(curR>=0 && curC>=0 && curR<m && curC<n && mat[curR][curC]==1 && distance[curR][curC] == -1){
                    distance[curR][curC]=distance[r][c]+1;
                    q.offer(new int[]{curR,curC});
                }
            }
        }
        return distance;
    }
}