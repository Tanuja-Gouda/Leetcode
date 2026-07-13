class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] dp=new boolean[n];

        dp[n-1]=true;

        for(int i=n-2;i>=0;i--){
            if(nums[i] == 0){
                continue;
            }
            for(int jump=1;jump<=nums[i];jump++){

                if(i+jump >= n){
                    break;
                }

                if(dp[i+jump]){
                    dp[i] = true;
                }
            }
        }
        return dp[0];

        // return find(0,nums,dp);
    }

    // public boolean find(int ind, int[] nums,Boolean[] dp){
    //     if(ind==nums.length-1){
    //         return true;
    //     }

    //     if(nums[ind] == 0){
    //         return false;
    //     }

    //     if(dp[ind] != null){
    //         return dp[ind];
    //     }

    //     for(int i=1;i<=nums[ind];i++){
    //         if(ind+i >= nums.length){
    //             break;
    //         }

    //         if(find(ind+i, nums,dp)){
    //             return dp[ind]=true;
    //         }
    //     }

    //     return dp[ind] = false;

    // }
}