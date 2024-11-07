class Solution {
    public int maxSubArray(int[] nums) {
        // BETTER
        // int max=Integer.MIN_VALUE; int n=nums.length;
        // for(int i=0;i<n;i++){
        //     int sum = 0;
        //     for(int j = i; j < n; j++){
        //         sum = sum + nums[j];
        //         if(sum>max)
        //             max = sum;
        //     }
        // }
        // return max;
        
        int sum = 0; int maximum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum > maximum)
                maximum = sum;
            if(sum<0)
                sum=0;
        }
        return maximum;
    }
}