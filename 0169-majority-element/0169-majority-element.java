class Solution {
    public int majorityElement(int[] nums) {
     // BRUT FORCE        
    // int n=nums.length;
    //     for(int i=0;i<n;i++){
    //         int major = nums[i];
    //         int count = 0;
    //         for(int j=0;j<n;j++){
    //             if(nums[j] == major){
    //                 count += 1;
    //             }
    //             if(count > n/2){
    //                 return major;
    //             }
    //         }
    //     }
    //     return 0;
        
        // OPTIMAL
        int count = 0;
        int major = 0;
        for(int num:nums){
            if(count == 0){
                major = num;
            }
            if(num == major){
                count++;
            }else{
                count--;
            }
        }
        return major;
    }
}