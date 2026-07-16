class Solution {

    int[] dp;
    public int jump(int[] nums) {
        dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return findJump(nums,0);
    }

    private int findJump(int[] nums,int ind){
        if(ind==nums.length-1){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }        

        int min=Integer.MAX_VALUE;
        for(int i=ind+1;i<=Math.min(nums.length-1,ind+nums[ind]);i++){
            int steps=findJump(nums,i);
            if (steps != Integer.MAX_VALUE){
                min = Math.min(min, 1 + steps);
            }
        }

        return dp[ind] = min;
    }
}
        // int jumps = 0;
        // int currentEnd = 0;
        // int farthest = 0;

        // for (int i = 0; i < nums.length - 1; i++) {

        //     farthest = Math.max(
        //             farthest,
        //             i + nums[i]);

        //     if (i == currentEnd) {

        //         jumps++;
        //         currentEnd = farthest;
        //     }
        // }

        // return jumps;