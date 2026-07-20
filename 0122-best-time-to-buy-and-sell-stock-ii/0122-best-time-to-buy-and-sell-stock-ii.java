class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int nextBuy=0;
        int nextSell=0;
        int profit=0;

        for(int i=n-1;i>=0;i--){
            int curBuy=0;
            int curSell=0;
            for(int buy=1;buy>=0;buy--){
                if(buy==1){
                    curBuy=Math.max(nextBuy, -prices[i]+nextSell);
                }else{
                    curSell=Math.max(nextSell, prices[i]+nextBuy);
                }
            }
            nextBuy=curBuy;
            nextSell=curSell;
        }
        return nextBuy;
    }
}