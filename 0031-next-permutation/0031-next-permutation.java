class Solution {
    public void nextPermutation(int[] nums) {
        int ind=-1;

        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }

        if(ind==-1){
            rev(nums,0,nums.length-1);
        }else{
                for(int i=nums.length-1;i>ind;i--){
                if(nums[i] > nums[ind]){
                    int temp=nums[ind];
                    nums[ind]=nums[i];
                    nums[i]=temp;
                    break;
                }
            }
           rev(nums,ind+1,nums.length-1);
        }
    }

    public void rev(int arr[],int start,int end){
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}