class Solution {
    int[] dp;
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[] temp=new int[max+1];
        for(int i=0;i<n;i++){
            temp[nums[i]] += 1;
        }

        dp=new int[max+1];
        Arrays.fill(dp,-1);

        return getPoints(temp,0);
    }

    public int getPoints(int[] temp, int ind){
        if(ind>temp.length-1){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int pick=(temp[ind]*ind)+getPoints(temp,ind+2);
        int notPick=getPoints(temp,ind+1);

        return dp[ind] = Math.max(pick,notPick);
    }
}