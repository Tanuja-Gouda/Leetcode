class Solution {
    public void sortColors(int[] nums) {
//         int zeros=0;int ones=0;
//         for(int num:nums){
//             if(num==0) zeros++;
//             else if(num==1) ones++;
//         }

//         for(int i=0;i<zeros;++i){
//             nums[i]=0;
//         }
//         for(int i=zeros;i<zeros+ones;++i){
//             nums[i]=1;
//         }
//         for(int i=zeros+ones;i<nums.length;++i){
//             nums[i]=2;
//         }
        
        int count_0 = 0, count_1 = 0;
        for(int num:nums){
            if(num == 0) count_0++;
            else if(num == 1) count_1++;
        }
        for(int i=0;i<count_0;i++){
            nums[i]=0;
        }
        for(int i=count_0;i<count_0+count_1;i++){
            nums[i]=1;
        }
        for(int i=count_0+count_1;i<nums.length;i++){
            nums[i]=2;
        }
    }
}