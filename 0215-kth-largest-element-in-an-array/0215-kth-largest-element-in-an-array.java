class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int largest = n-k;
        return nums[largest];
    }
    // public void mergeSort(int[] nums){
        // int left = 0;
        // int right = nums.length-1;
        // while(left<right){
        //     int  mid = left + (mid-left)/2;
        //     mergeSort(nums,left,mid-1);
        //     mergeSort(nums,mid+1,right);
        //     merge(nums,left, mid, right);
        // }
    // }
}