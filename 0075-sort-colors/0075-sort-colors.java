class Solution {
    public void sortColors(int[] nums) {

        // for(int num:nums){
        //     if(num==0) zeros++;
        //     else if(num==1) ones++;
        // }
        
        // int count_0 = 0, count_1 = 0;
        // for(int i=0;i<=nums.length-1;i++){
        //     if(nums[i] == 0) count_0++;
        //     else if(nums[i] == 1) count_1++;
        // }
        // for(int i=0;i<count_0;i++){
        //     nums[i]=0;
        // }
        // for(int i=count_0;i<count_0+count_1;i++){
        //     nums[i]=1;
        // }
        // for(int i=count_0+count_1;i<nums.length;i++){
        //     nums[i]=2;
        // }
        
        int n=nums.length;
        int low=0,mid=0,high=n-1;
        while(mid<=high){
            if(nums[mid] == 0){
                swap(nums,mid,low);
                // int temp = nums[mid];
                // nums[mid] = nums[low];
                // nums[low] = temp;
                
                mid += 1;
                low += 1;
            }else if(nums[mid] == 1) {
                mid += 1;
            }else {
                swap(nums,mid,high);
                // int temp = nums[mid];
                // nums[mid] = nums[high];
                // nums[high] = temp;
                high -= 1;
            }
        }
    }
    public void swap(int []nums,int i,int j){
           int temp = nums[i];
           nums[i] = nums[j];
           nums[j] = temp;
    }
}