class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int num:nums){
            totalSum += num;
        }

        if((totalSum%2) == 1){
            return false;
        }

        int target=totalSum/2;

        boolean[] prev=new boolean[target +1];

        prev[0]=true;

        if(nums[0] <= target){
            prev[nums[0]]=true;
        }

        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                boolean notTake=prev[j];
                boolean take=false;
                if(nums[i] <= j){
                    take=prev[j-nums[i]];
                }
                prev[j]=take || notTake;
            }
        }

        return prev[target];



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