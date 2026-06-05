class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int m = potions.length;

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int low = 0, high = m - 1;
            int firstValid = m;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                if ((long) spells[i] * potions[mid] >= success) {
                    firstValid = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = m - firstValid;
        }

        return ans;
    }
}