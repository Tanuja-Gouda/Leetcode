class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return findMoney(nums,n-1,dp);
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