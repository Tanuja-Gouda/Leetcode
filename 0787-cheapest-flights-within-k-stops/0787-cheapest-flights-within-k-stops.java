class Solution {

    public int findCheapestPrice(int n,
                                 int[][] flights,
                                 int src,
                                 int dst,
                                 int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {

            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            adj.get(u).add(new int[]{v, cost});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{src, 0, 0});
        distance[src] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int node = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if (stops > k) {
                continue;
            }

            for (int[] neighbor : adj.get(node)) {

                int nextNode = neighbor[0];
                int price = neighbor[1];

                if (cost + price < distance[nextNode]
                        && stops <= k) {

                    distance[nextNode]
                            = cost + price;

                    q.offer(new int[]{
                            nextNode,
                            distance[nextNode],
                            stops + 1
                    });
                }
            }
        }

        return distance[dst]
                == Integer.MAX_VALUE
                ? -1
                : distance[dst];
    }
}