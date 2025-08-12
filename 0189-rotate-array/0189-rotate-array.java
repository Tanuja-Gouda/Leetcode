class Solution {

    static void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


   public void rotate(int[] nums, int k) {
    int n=nums.length;
    k=k%n;
    reverse(nums,0,n-k-1);
    reverse(nums,n-k,n-1);
    reverse(nums,0,n-1);











    //     k=k%nums.length;
    //     reverse(nums,0,nums.length-1);
    //     reverse(nums,0,k-1);
    //     reverse(nums,k,nums.length-1);
    // }

    // public void reverse(int[] nums, int start, int end){
    //    while(start<end){
    //     int temp=nums[start];
    //     nums[start]=nums[end];
    //     nums[end]=temp;
    //     start++;
    //     end--;
    //    }

    // BRUT FORCE:
    
    //   k = k % nums.length;
    //   int n=nums.length;
    //   int temp[]=new int[n];
    //   for(int i=n-k;i<n;i++){
    //     temp[i-(n-k)]=nums[i];
    //   }

    //   for(int i=0;i<n-k;i++){
    //     temp[i+k]=nums[i];
    //   }

    //   for(int i=0;i<n;i++){
    //     nums[i]=temp[i];
    //   }
    
//     k = k %  nums.length;
//     int n=nums.length;
//     reverse(nums,0,n-k-1);
//     reverse(nums,n-k,n-1);
//     reverse(nums,0,n-1);
//    }
//     private void reverse(int[] nums, int start, int end){
//        while(start <= end){
//         int temp=nums[start];
//         nums[start]=nums[end];
//         nums[end]=temp;
//         start++;
//         end--;
//        }
    }
}