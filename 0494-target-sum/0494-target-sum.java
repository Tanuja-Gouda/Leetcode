class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int Sum=0;
        for(int num:nums){
            Sum += num;
        }

        int totalSum = Sum+target;

        if((totalSum%2) == 1 || Sum<Math.abs(target)){
            return 0;
        }

        if(n==1 && nums[0] == 0){
            return 2;
        }

        int reqTarget=totalSum/2;

        int[] prev=new int[reqTarget+1];

        prev[0]=1;

        if(nums[0] <= reqTarget){
            prev[nums[0]] += 1;
        }

        for(int i=1;i<n;i++){
            for(int j=reqTarget;j>=0;j--){
                int notTake=prev[j];
                int take=0;
                if(nums[i] <= j){
                    take=prev[j-nums[i]];
                }
                prev[j]=take + notTake;
            }
        }

        return prev[reqTarget];



    }
}