class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        // int[] dp=new int[n];
        // Arrays.fill(dp,-1);

        // dp[0]=nums[0];
        // for(int i=1;i<n;i++){
        //     int notTake = 0+dp[i-1];
        //     int take=nums[i];
        //     if(i>1){
        //       take += dp[i-2];
        //     }

        //     dp[i]=Math.max(take,notTake);
        // }
        // return dp[n-1];


        // return findMoney(nums,n-1,dp);

        if(n==1){
            return nums[0];
        }

        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int max=Math.max(nums[i]+prev2 , prev1);
            prev2=prev1;
            prev1=max;
        }
        return prev1;
    }

    private static int findMoney(int[] nums,int n,int[] dp){
        if(n<0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int take=nums[n] + findMoney(nums,n-2,dp);
        int notTake = 0+findMoney(nums,n-1,dp);

        return dp[n]=Math.max(take,notTake);
    }
}