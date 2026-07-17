class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // Impossible cases
        if (Math.abs(target) > sum)
            return 0;

        if ((sum + target) % 2 != 0)
            return 0;

        int req = (sum + target) / 2;
        int n = nums.length;

        int[][] dp = new int[n + 1][req + 1];

        // One way to make sum 0: choose nothing
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= req; j++) {

                // Not take
                dp[i][j] = dp[i - 1][j];

                // Take
                if (nums[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[n][req];
    }
}