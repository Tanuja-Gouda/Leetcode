class Solution {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;

        long rob = nums[0];   // Rob current house
        long skip = 0;        // Skip current house

        for (int i = 1; i < n; i++) {

            long newRob;
            long newSkip = Math.max(rob, skip);

            if (colors[i] == colors[i - 1]) {
                // Adjacent houses have the same color,
                // so we can't rob both.
                newRob = nums[i] + skip;
            } else {
                // Different colors,
                // so robbing both adjacent houses is allowed.
                newRob = nums[i] + Math.max(rob, skip);
            }

            rob = newRob;
            skip = newSkip;
        }

        return Math.max(rob, skip);
    }
}