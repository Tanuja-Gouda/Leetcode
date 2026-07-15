class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return maxProfit(nums,0);
    }

    private int maxProfit(int[] nums,int ind){
        if(ind>=nums.length){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int pick=nums[ind]+maxProfit(nums,ind+2);
        int notPick=0+maxProfit(nums,ind+1);

        return dp[ind] = Math.max(pick,notPick);
    }
}