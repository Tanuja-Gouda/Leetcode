class Solution {
    public int missingNumber(int[] nums) {
        // BRUT FORCE SOLUTION:-
        // for(int i=0;i<=nums.length;i++){
        //     int flag=0;
        //     for(int j=0;j<nums.length;j++){
        //         if(nums[j] == i){
        //             flag = 1;
        //             break;
        //         }
        //     }
        //     if(flag == 0){
        //         return i;
        //     }
        // }
        // return -1;


        int n = nums.length;
        int totalSum = (n*(n+1))/2;

        int sum=0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }

        int res = totalSum - sum;
        if(res >= 0){
            return res;
        }

        return -1;


        // OPTIMAL SOLUTION:-
        // int n=nums.length;
        // int totalSum= (n*(n+1))/2;

        // int sum=0;
        // for(int i=0;i<n;i++){
        //     sum = sum+nums[i];
        // } 

        // int result = totalSum - sum;
        // if(result >= 0){
        //     return result;
        // }

        // return -1;

        // int i=0;
        //  while(i<nums.length)
        //  {
        //     int correct=nums[i];
        //     if(nums[i]<nums.length && nums[i]!=nums[correct])
        //     {
        //         int temp=nums[correct];
        //         nums[correct]=nums[i];
        //         nums[i]=temp;
        //     }
        //     else
        //     i++;
        //  }
        //  for(int index=0;index<nums.length;index++)
        //  {
        //     if(nums[index]!=index)
        //      return index;
        //  }
        //   return nums.length;
    }
}