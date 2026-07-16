class Solution {
    int[] dp;
    public int numDecodings(String s) {
        dp=new int[s.length()];
        Arrays.fill(dp,-1);
        return find(s,0);
    }

    private int find(String s,int ind){
        if(ind==s.length()){
            return 1;
        }

        if(s.charAt(ind) == '0'){
            return 0;
        }

        if(dp[ind] != -1){
            return dp[ind];
        }

        int takeOne = find(s,ind+1);

        int takeTwo = 0;

        if(ind+1 < s.length()){
            int num = (s.charAt(ind)-'0') * 10 + (s.charAt(ind+1) - '0');

            if(num>=10 && num<=26){
                takeTwo=find(s,ind+2);
            }
        }
        return dp[ind] = takeOne+takeTwo;

    }
}