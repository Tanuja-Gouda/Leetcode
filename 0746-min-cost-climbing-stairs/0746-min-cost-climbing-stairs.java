class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return minCost(cost,n);
    }

    private int minCost(int[] cost,int n){
        if(n<0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int step1=0;
        int step2=0;
        if(n==cost.length){
            step1 += minCost(cost,n-1);
            step2 += minCost(cost,n-2);
        }else{
            step1 += cost[n] + minCost(cost,n-1);
            step2 += cost[n] + minCost(cost,n-2);
        }

        return dp[n] = Math.min(step1,step2);

    }
}