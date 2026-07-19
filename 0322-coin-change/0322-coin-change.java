class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                prev[i]=i/coins[0];
            }else{
                prev[i]=Integer.MAX_VALUE;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                int notTake=prev[j];
                int take=Integer.MAX_VALUE;
                if(coins[i] <= j){
                    int ans=prev[j-coins[i]];

                    if(ans != Integer.MAX_VALUE){
                        take = 1+ans;
                    }
                }
                prev[j]=Math.min(take,notTake);
            }
        }
        return prev[amount] != Integer.MAX_VALUE ? prev[amount] : -1;
    }
}
