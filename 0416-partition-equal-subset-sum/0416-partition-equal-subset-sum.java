class Solution {
    boolean[] dp;
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
        dp=new boolean[target+1];

        if(nums[0]<=target){
            dp[nums[0]]=true;
        }
        dp[0]=true;

        for(int i=1;i<nums.length;i++){
            boolean[] cur=new boolean[target+1];
            cur[0]=true;
            for(int j=1;j<=target;j++){
                boolean take=false;
                if(nums[i]<=j){
                    take=dp[j-nums[i]];
                }
                boolean notTake=dp[j];
                cur[j]=take || notTake;
            }
            dp=cur;
        }

        return dp[target];



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