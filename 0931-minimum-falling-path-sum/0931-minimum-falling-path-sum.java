class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int[] prev=new int[n];

        for(int i=0;i<n;i++){
            prev[i]=matrix[0][i];
        }

        for(int i=1;i<=m-1;i++){
            int[] cur=new int[n];
            for(int j=0;j<n;j++){
                int ld=Integer.MAX_VALUE;
                int bt=Integer.MAX_VALUE;
                int rd=Integer.MAX_VALUE;
                if(j>0) ld=prev[j-1];
                bt=prev[j];
                if(j<n-1){
                    rd=prev[j+1];
                }

                cur[j]=matrix[i][j]+Math.min(ld, Math.min(bt,rd));
            }

            prev=cur;
        }

        int ans=Integer.MAX_VALUE;
        for(int num:prev){
            ans=Math.min(num,ans);
        }
         return ans;
    }
}