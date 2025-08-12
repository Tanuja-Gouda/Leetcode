class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;

        for(int j=0;j<nums.length;j++){
            if(nums[j]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i]=temp;
                i++;
            }
        }








        // OPTIMAL SOLUTION:-
        // int n=nums.length;

        // int j=0;
        // for(int i=0;i<n;i++){
        //     if(nums[i] != 0){
        //         int temp = nums[j];
        //         nums[j] = nums[i];
        //         nums[i] = temp;
        //         j++;
        //     }
        // }

        // BRUT FORCE SOLUTION:-
        // int n=nums.length;
        // int [] temp = new int[n];  
        // int j=0;
        // for(int i=0;i<n;i++){
        //     if(nums[i]!=0){
        //         temp[j]=nums[i];
        //         j++;
        //     }
        // }
        // for(int i=0;i<temp.length;i++){
        //     nums[i]=temp[i];
        // }
        // for(int i=temp.length;i<n;i++){
        //     nums[i]=0;
        // }


        // int left=0;
        // for(int right=0;right<nums.length;right++){
        //     if(nums[right] != 0){
        //         int temp=nums[right];
        //         nums[right]=nums[left];
        //         nums[left]=temp;
        //         left++;
        //     }
        // }
    }
}