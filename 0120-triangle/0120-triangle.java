class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[] next=new int[n];

        for(int i=0;i<n;i++){
            next[i]=triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            int[] cur=new int[n];
            for(int j=0;j<=i;j++){
                int b=next[j];
                int d=Integer.MAX_VALUE;
                if(j<=i){
                    d=next[j+1];
                }
                cur[j]=triangle.get(i).get(j) + Math.min(b,d);
            }
            next=cur;
        }
        return next[0];
    }
}