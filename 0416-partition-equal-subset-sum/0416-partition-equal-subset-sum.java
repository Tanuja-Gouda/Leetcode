class Solution {
    boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int num:nums){
            totalSum += num;
        }

        if(totalSum%2 == 1){
            return false;
        }

        int target=totalSum/2;
        dp=new boolean[n][target+1];

        for(int i=0;i<nums.length;i++){
            dp[i][0]=true;
        }

        if(nums[0]<=target){
            dp[0][nums[0]]=true;
        }

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<=target;j++){
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[i-1][j-nums[i]];
                }
                boolean notTake=dp[i-1][j];
                dp[i][j]=take || notTake;
            }
        }

        return dp[n-1][target];



        // return findTarget(nums,target,0);
    }

    // public boolean findTarget(int[] nums, int target,int ind){
    //     if(target==0){
    //         return true;
    //     }
    //     if(ind==nums.length){
    //         return false;
    //     }

    //     if(dp[ind][target] != null){
    //         return dp[ind][target];
    //     }

    //     boolean take=false;

    //     if(nums[ind]<=target){
    //         take=findTarget(nums,target-nums[ind],ind+1);
    //     }
        
    //     boolean notTake=findTarget(nums,target,ind+1);

    //     return dp[ind][target] = take || notTake;
    // }
}