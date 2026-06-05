class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int low = 0, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int idx = lowerBound(nums, mid);
            int count = n - idx;

            if (count == mid) {
                return mid;
            } else if (count > mid) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}