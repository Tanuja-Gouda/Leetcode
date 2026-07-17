class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] dp=new int[amount+1];

        for(int i=0;i<=amount;i++){
            if(i%coins[0] ==0){
                dp[i]=i/coins[0];
            }
            else{
                dp[i] = Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                int notTake=dp[j];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=j){
                    int res=dp[j-coins[i]];
                    if(res != Integer.MAX_VALUE){
                        take = 1+res;
                    }
                }
                dp[j]=Math.min(take,notTake);
            }
        }
        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }
}