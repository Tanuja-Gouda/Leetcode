class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[left]<=nums[mid]){
                if(nums[left]<=target && target<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(nums[mid]<=target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;

















        // int low = 0;
        // int high = nums.length-1;
        // while(low<=high){
        //     int mid = low + (high-low)/2;
        //     if(nums[mid]==target){
        //         return mid;
        //     }

        //     if(nums[low]<=nums[mid]){
        //         if(nums[low]<=target && target<=nums[mid]){
        //             high = mid-1;
        //         }
        //         else{
        //             low=mid+1;
        //         }
        //     }else{
        //         if(nums[mid]<=target && target<=nums[high]){
        //             low=mid+1;
        //         }
        //         else{
        //             high=mid-1;
        //         }
        //     }
        // }
        // return -1;
    }
}