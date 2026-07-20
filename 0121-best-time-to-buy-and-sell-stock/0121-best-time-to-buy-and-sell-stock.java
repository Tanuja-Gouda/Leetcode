class Solution {
    public int maxProfit(int[] prices) {
       int n=prices.length;
       int buy=prices[0];

       int maxProfit=0;
       for(int i=1;i<n;i++){
        int curProfit=-buy+prices[i];
        maxProfit=Math.max(maxProfit, curProfit);
        buy=Math.min(buy,prices[i]);
       }
       return maxProfit;
    }
}