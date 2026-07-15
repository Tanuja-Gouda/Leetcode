class Solution {
    int[] dp;
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        dp=new int[n];

        int ans = 1;

        for(int i=0;i<n;i++){
            ans=Math.max(ans,findJump(arr,d,i));
        }

        return ans;
    }

    public int findJump(int[] arr,int d,int ind){

        if(dp[ind] != 0){
            return dp[ind];
        }
        int max=1;

        for(int i=ind-1;i>=Math.max(0,ind-d);i--){
            if(arr[i] >= arr[ind]){
                break;
            }

            max=Math.max(max, 1+findJump(arr,d,i));
        }

        for(int i=ind+1;i<=Math.min(arr.length-1,ind+d);i++){
            if(arr[i] >= arr[ind]){
                break;
            }

            max=Math.max(max, 1+findJump(arr,d,i));
        }

        return dp[ind]=max;
    }
}