class Solution {
    public int[] rearrangeArray(int[] nums) {
        // BRUTT
        // int n=nums.length;
        // int pos[] = new int[n/2];
        // int neg[] = new int[n/2];
        // int j = 0, k = 0;
        // for(int i=0;i<n;i++){
        //     if(nums[i] < 0){
        //         neg[j] = nums[i];
        //         j++;
        //     }else {
        //         pos[k] = nums[i];
        //         k++;
        //     }
        // }
        // for(int i=0;i<n/2;i++){
        //     nums[2 * i] = pos[i];
        //     nums[2 * i + 1] = neg[i];
        // }
        // return nums;
        
        // OPTIMAL
        int n = nums.length;
        int result[] = new int[n]; 
        int posIndex=0, negIndex=1;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                result[negIndex] = nums[i];
                negIndex += 2;
            }else{
                result[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return result;
    }
}