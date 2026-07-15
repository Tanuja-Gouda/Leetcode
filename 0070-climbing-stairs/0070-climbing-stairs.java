class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
       return findWays(n);
    }

    private int findWays(int n){
        if(n==0 || n==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int step1=findWays(n-1);
        int step2=findWays(n-2);

        return dp[n] = step1+step2;
    }
}