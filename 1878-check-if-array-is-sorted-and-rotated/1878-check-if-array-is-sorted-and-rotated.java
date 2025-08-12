class Solution {
    public boolean check(int[] nums) {
        int decrease = 1;
        for(int i=0;i<nums.length;i++){
            if(i == nums.length-1){
                if(nums[i] > nums[0]){
                    decrease--;
                }
            }else if(nums[i] > nums[i+1]){
                decrease--;
            }
            if(decrease < 0){
                return false;
            }
        }
        return true;
    }
}