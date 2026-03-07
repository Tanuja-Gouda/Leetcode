class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxCount=0;
        int count=0;

        int lastSmaller=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSmaller){
                count += 1;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller){
                lastSmaller = nums[i];
                count = 1;
            }
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}