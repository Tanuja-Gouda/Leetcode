class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length;
        Boolean[][] dp=new Boolean[n][n+1];
        return find(0,stones,0,dp);
    }

    public boolean find(int ind, int[] nums,int unit,Boolean[][] dp){
        if(ind==nums.length-1){
            return true;
        }

        if(ind==0){
            if(nums[ind+1]-nums[ind]==1){
                return find(ind+1,nums,1,dp);
            }else{
                return false;
            }
        }

        if(dp[ind][unit] != null){
            return dp[ind][unit];
        }

        int k__1=nums[ind]+unit-1;
        int k=nums[ind]+unit;
        int k_1=nums[ind]+unit+1;

        for(int i=ind+1;i<nums.length;i++){
            if(unit>1 && nums[i]==k__1 || nums[i]==k || nums[i]==k_1 ){
                if(find(i,nums,nums[i]-nums[ind],dp)){
                    return dp[ind][unit]=true;
                }
            }
            if(nums[i] > k_1){
                break;
            }
        }
        return dp[ind][unit]=false;
    }
}