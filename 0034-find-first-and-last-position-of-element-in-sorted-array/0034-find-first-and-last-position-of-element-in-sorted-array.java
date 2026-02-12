class Solution {



    //     int low = 0;
    //     int high = nums.length-1;
    //     int ans = -1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         if(nums[mid]==x){
    //             ans=mid;
    //             high=mid-1;
    //         }
    //         else if(nums[mid]<x){
    //             low=mid+1;
    //         }else{
    //             high = mid-1;
    //         }
    //     }
    //     return ans;
    // }

    //  static int findLastIndex(int[] nums,int x){
    //     int low = 0;
    //     int high = nums.length-1;
    //     int ans = -1;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         if(nums[mid]==x){
    //             ans=mid;
    //             low=mid+1;
    //         }
    //         else if(nums[mid]<x){
    //             low=mid+1;
    //         }else{
    //             high = mid-1;
    //         }
    //     }
    //     return ans;
    // }

    static int findFirstIndex(int[] nums,int target){
        int ans=-1;
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=(left+right)/2;

            if(nums[mid]==target){
                ans=mid;
                right=mid-1;
            }else if(nums[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }

    static int findLastIndex(int[] nums,int target){
        int low=0;
        int high=nums.length-1;
        int ans=-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(nums[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(nums[mid]>target){
                high=mid-1;

            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int firstIndex=findFirstIndex(nums,target);
        int lastIndex=findLastIndex(nums,target);

        return new int[] {firstIndex,lastIndex};






    //     int first =findFirstIndex(nums,target);
    //     int last = findLastIndex(nums,target);

    //     return new int[] {first,last};

    }
}