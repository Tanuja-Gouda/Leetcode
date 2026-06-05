class Solution {

    public int shortestPathLength(int[][] graph) {

        int n = graph.length;

        int finalMask = (1 << n) - 1;

        Queue<int[]> q = new LinkedList<>();

        boolean[][] visited =
                new boolean[n][1 << n];

        for (int i = 0; i < n; i++) {

            int mask = 1 << i;

            q.offer(new int[]{i, mask});
            visited[i][mask] = true;
        }

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int node = curr[0];
                int mask = curr[1];

                if (mask == finalMask) {
                    return steps;
                }

                for (int neighbor : graph[node]) {

                    int nextMask =
                            mask | (1 << neighbor);

                    if (!visited[neighbor]
                                 [nextMask]) {

                        visited[neighbor]
                               [nextMask] = true;

                        q.offer(new int[]{
                                neighbor,
                                nextMask
                        });
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}