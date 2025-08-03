class Solution {
    public int singleNonDuplicate(int[] nums) {
        // int result=nums[0];
        // for(int i=1;i<=nums.length-1;i++){
        //     result ^= nums[i];
        // }
        // return result;

        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid = low+(high-low)/2;
            if(mid%2==1){
                mid=mid-1;
            }
            if(nums[mid]==nums[mid+1]){
                low=mid+2;
            }else{
                high=mid;
            }
        }
        return nums[low];
    }
}