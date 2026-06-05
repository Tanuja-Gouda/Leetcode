class Solution {

    private int[] prefix;
    private Random random;

    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];

        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }

        random = new Random();
    }

    public int pickIndex() {
        int target = random.nextInt(prefix[prefix.length - 1]) + 1;

        int low = 0, high = prefix.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prefix[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */