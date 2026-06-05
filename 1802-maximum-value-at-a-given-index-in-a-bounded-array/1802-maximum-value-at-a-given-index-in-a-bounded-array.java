class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int left = 1, right = maxSum;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;

            if (isPossible(n, index, maxSum, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean isPossible(int n, int index, int maxSum, int value) {
        long leftSum = calc(value - 1, index);
        long rightSum = calc(value - 1, n - index - 1);

        long total = leftSum + rightSum + value;

        return total <= maxSum;
    }

    private long calc(long peak, int len) {
        if (peak >= len) {
            long small = peak - len + 1;
            return (peak + small) * len / 2;
        } else {
            long sum = (peak + 1) * peak / 2;
            return sum + (len - peak);
        }
    }
}