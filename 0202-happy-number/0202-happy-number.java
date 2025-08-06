class Solution {

    static int findSquare(int num){
        int ans = 0;
        while(num > 0){
            int rem = num % 10;
            ans += rem*rem;
            num /= 10;
        }
        return ans;
    }

    public boolean isHappy(int n) {
        // if(n==1 || n==7) return true;
        // else if(n<10) return false;
        // else{
        //     int sum=0;
        //     while(n>0){
        //         int temp=n%10;
        //         sum+= temp*temp;
        //         n=n/10;
        //     }
        //     return isHappy(sum);
        // }

        int fast = n;
        int slow = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow == 1){
            return true;
        }
        return false;
    }
}