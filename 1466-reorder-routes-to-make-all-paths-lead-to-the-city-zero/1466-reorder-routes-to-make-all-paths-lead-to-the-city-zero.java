class Solution {

    public int minReorder(int n, int[][] connections) {

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, adj, visited);
    }

    private int dfs(int node,
                    List<List<int[]>> adj,
                    boolean[] visited) {

        visited[node] = true;

        int changes = 0;

        for (int[] neighbor : adj.get(node)) {

            int nextNode = neighbor[0];
            int cost = neighbor[1];

            if (!visited[nextNode]) {

                changes += cost;

                changes += dfs(nextNode,
                               adj,
                               visited);
            }
        }

        return changes;
    }
}