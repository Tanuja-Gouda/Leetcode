import java.util.*;

class Solution {

    public int oddEvenJumps(int[] arr) {
        int n = arr.length;

        int[] nextHigher = make(arr, true);
        int[] nextLower = make(arr, false);

        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        odd[n - 1] = true;
        even[n - 1] = true;

        int ans = 1;

        for (int i = n - 2; i >= 0; i--) {

            if (nextHigher[i] != -1)
                odd[i] = even[nextHigher[i]];

            if (nextLower[i] != -1)
                even[i] = odd[nextLower[i]];

            if (odd[i])
                ans++;
        }

        return ans;
    }

    private int[] make(int[] arr, boolean higher) {

        int n = arr.length;

        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++)
            idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            if (arr[a] != arr[b]) {
                return higher ? arr[a] - arr[b] : arr[b] - arr[a];
            }
            return a - b;
        });

        int[] next = new int[n];
        Arrays.fill(next, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i : idx) {

            while (!stack.isEmpty() && i > stack.peek()) {
                next[stack.pop()] = i;
            }

            stack.push(i);
        }

        return next;
    }
}