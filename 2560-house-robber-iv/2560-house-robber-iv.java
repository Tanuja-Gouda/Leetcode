class Solution {
    public int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean canRob(int[] nums, int k, int capability) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                count++;
                i++; // skip adjacent house
            }
        }

        return count >= k;
    }
}