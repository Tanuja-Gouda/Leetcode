import java.util.*;

class Solution {

    public int maxResult(int[] nums, int k) {

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(0);

        for (int i = 1; i < n; i++) {

            while (!dq.isEmpty() && dq.peekFirst() < i - k) {
                dq.pollFirst();
            }

            dp[i] = dp[dq.peekFirst()] + nums[i];

            while (!dq.isEmpty() && dp[dq.peekLast()] <= dp[i]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return dp[n - 1];
    }
}




// class Solution {
//     int[] dp;
//     public int maxResult(int[] nums, int k) {
//         int n = nums.length;
//         int[] dp = new int[n];

//         dp[0] = nums[0];

//         for (int i = 1; i < n; i++) {

//             dp[i] = Integer.MIN_VALUE;

//             for (int j = Math.max(0, i - k); j < i; j++) {
//                 dp[i] = Math.max(dp[i], dp[j] + nums[i]);
//             }
//         }

//         return dp[n - 1];


//         // Arrays.fill(dp,-1);
//         // return findResult(0,nums,k,dp);

//     }

//     // public int findResult(int ind,int[] nums,int k,int[] dp){
//     //     int n=nums.length-1;
//     //     if(ind==n){
//     //         return nums[ind];
//     //     }

//     //     if(dp[ind] != -1){
//     //         return dp[ind];
//     //     }

//     //     int ans=Integer.MIN_VALUE;
//     //     for(int i=ind+1;i<=Math.min(ind+k, n);i++){
//     //         int sum = nums[ind]+findResult(i,nums,k,dp);
//     //         ans=Math.max(ans,sum);
//     //     }

//     //     return dp[ind] = ans;
//     // }
// }