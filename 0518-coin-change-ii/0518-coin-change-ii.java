class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0] == 0){
                prev[i]=1;
            }else{
                prev[i]=0;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                int notTake=prev[j];
                int take=0;
                if(coins[i] <= j){
                    take=prev[j-coins[i]];
                }
                prev[j]=(take+notTake);
            }
        }
        return prev[amount];
    }
}