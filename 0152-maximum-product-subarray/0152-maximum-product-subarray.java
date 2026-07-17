class Solution {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int minProd=nums[0];
        int maxProd=nums[0];
        for(int i=1;i<nums.length;i++){
            int min=Math.min(nums[i], Math.min(minProd*nums[i], maxProd*nums[i]));
            int max=Math.max(nums[i], Math.max(minProd*nums[i], maxProd*nums[i]));

            minProd=min;
            maxProd=max;

            ans=maxProd>ans ? maxProd : ans;
        }
        return ans;
    }
}