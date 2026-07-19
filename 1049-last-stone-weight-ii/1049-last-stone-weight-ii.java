class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int totalSum=0;
        for(int num:stones){
            totalSum += num;
        }

        int target=totalSum/2;

        boolean[] prev=new boolean[target +1];

        prev[0]=true;

        if(stones[0] <= target){
            prev[stones[0]]=true;
        }

        for(int i=1;i<n;i++){
            for(int j=target;j>=0;j--){
                boolean notTake=prev[j];
                boolean take=false;
                if(stones[i] <= j){
                    take=prev[j-stones[i]];
                }
                prev[j]=take || notTake;
            }
        }

        int s1=0;
        for(int i=target;i>=0;i--){
            if(prev[i]){
                s1=i;
                break;
            }
        }

        return totalSum-(2*s1);
    }
}