class Solution {
    public int maxProfit(int[] prices) {
        int p = prices.length;
        int min = prices[0];
        int maxProfit = 0;
        for(int i=1;i<p;i++){
            int cost = prices[i] - min;
           if(cost > maxProfit)
               maxProfit = cost;
           if(prices[i] < min)
               min = prices[i];
        }
        return maxProfit;
    }
}