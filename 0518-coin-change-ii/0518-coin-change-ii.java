class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        prev[0]=1;

        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=amount;j++){
                prev[j] += prev[j-coins[i]];
            }
        }
        return prev[amount];
    }
}