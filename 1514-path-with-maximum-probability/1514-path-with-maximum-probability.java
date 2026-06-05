class Solution {

    public double maxProbability(int n,
                                 int[][] edges,
                                 double[] succProb,
                                 int start,
                                 int end) {

        List<List<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            double prob = succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>(
                        (a, b) ->
                                Double.compare(
                                        b.probability,
                                        a.probability));

        pq.offer(new Pair(start, 1.0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            double probability = curr.probability;

            if (node == end) {
                return probability;
            }

            if (probability < maxProb[node]) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {

                int nextNode = neighbor.node;

                double newProb =
                        probability
                        * neighbor.probability;

                if (newProb > maxProb[nextNode]) {

                    maxProb[nextNode] = newProb;

                    pq.offer(
                            new Pair(
                                    nextNode,
                                    newProb));
                }
            }
        }

        return 0.0;
    }

    class Pair {

        int node;
        double probability;

        Pair(int node,
             double probability) {

            this.node = node;
            this.probability = probability;
        }
    }
}