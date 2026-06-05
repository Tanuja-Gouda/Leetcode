class Solution {

    public int networkDelayTime(int[][] times,
                                int n,
                                int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] time : times) {

            int u = time[0];
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(
                        (a, b) -> a[1] - b[1]);

        distance[k] = 0;
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int dist = curr[1];

            if (dist > distance[node]) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int weight = neighbor[1];

                if (dist + weight
                        < distance[nextNode]) {

                    distance[nextNode]
                            = dist + weight;

                    pq.offer(
                            new int[]{
                                    nextNode,
                                    distance[nextNode]
                            });
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (distance[i]
                    == Integer.MAX_VALUE) {

                return -1;
            }

            answer =
                    Math.max(answer,
                             distance[i]);
        }

        return answer;
    }
}