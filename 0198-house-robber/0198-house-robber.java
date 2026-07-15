class Solution {
    int[] dp;
    public int rob(int[] nums) {
        dp=new int[nums.length+1];

        dp[0]=nums[0];
        
        for(int i=1;i<nums.length;i++){
            int pick=nums[i];
            int notPick=dp[i-1];
            if(i>1){
                pick+=dp[i-2];
            }

            dp[i]=Math.max(pick,notPick);
        }

        return dp[nums.length-1];



        // Arrays.fill(dp,-1);
        // return maxProfit(nums,0);
    }

    // private int maxProfit(int[] nums,int ind){
    //     if(ind>=nums.length){
    //         return 0;
    //     }

    //     if(dp[ind] != -1){
    //         return dp[ind];
    //     }

    //     int pick=nums[ind]+maxProfit(nums,ind+2);
    //     int notPick=0+maxProfit(nums,ind+1);

    //     return dp[ind] = Math.max(pick,notPick);
    // }
}