class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;


        // int low = 0;
        // int high = nums.length - 1;
        // int ans = -1;
        // for(int i=0; i<nums.length;i++){
        //     while(low<=high){
        //     int mid = (low + high ) / 2;
        //     if(nums[mid] >= target){
        //      ans = mid;
        //      high = high - 1;
        //     }
        //     else
        //       low = low + 1;
        //     }
        // }
        // return ans;
    }
}