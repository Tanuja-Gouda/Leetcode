class Solution {
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int num:nums){
            totalSum += num;
        }

        dp=new Boolean[n+1][totalSum+1];
        if(totalSum%2 == 1){
            return false;
        }

        int target=totalSum/2;

        return findTarget(nums,target,0);
    }

    public boolean findTarget(int[] nums, int target,int ind){
        if(target==0){
            return true;
        }
        if(ind==nums.length){
            return false;
        }

        if(dp[ind][target] != null){
            return dp[ind][target];
        }

        boolean take=false;

        if(nums[ind]<=target){
            take=findTarget(nums,target-nums[ind],ind+1);
        }
        
        boolean notTake=findTarget(nums,target,ind+1);

        return dp[ind][target] = take || notTake;
    }
}