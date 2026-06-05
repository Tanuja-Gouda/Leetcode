class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        int MOD = 1_000_000_007;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        long ans = 0;

        for (int i = 0; i < n - 2; i++) {
            long leftSum = prefix[i];

            int low = i + 1, high = n - 2;
            int first = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long midSum = prefix[mid] - prefix[i];

                if (midSum >= leftSum) {
                    first = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            if (first == -1) continue;

            low = first;
            high = n - 2;
            int last = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long midSum = prefix[mid] - prefix[i];
                long rightSum = prefix[n - 1] - prefix[mid];

                if (midSum <= rightSum) {
                    last = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (last != -1) {
                ans = (ans + (last - first + 1)) % MOD;
            }
        }

        return (int) ans;
    }
}