class Solution {

     static int findFirstIndex(int[] nums,int x){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x){
                ans=mid;
                high=mid-1;
            }
            else if(nums[mid]<x){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }

     static int findLastIndex(int[] nums,int x){
        int low = 0;
        int high = nums.length-1;
        int ans = -1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x){
                ans=mid;
                low=mid+1;
            }
            else if(nums[mid]<x){
                low=mid+1;
            }else{
                high = mid-1;
            }
        }
        return ans;
    }


    public int[] searchRange(int[] nums, int target) {
        int first =findFirstIndex(nums,target);
        int last = findLastIndex(nums,target);

        return new int[] {first,last};

    }
}