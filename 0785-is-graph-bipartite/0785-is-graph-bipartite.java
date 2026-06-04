class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        for (int node = 0; node < n; node++) {

            if (color[node] == 0) {

                if (!dfs(node, 1, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        int currColor,
                        int[][] graph,
                        int[] color) {

        color[node] = currColor;

        for (int neighbor : graph[node]) {

            if (color[neighbor] == 0) {

                if (!dfs(neighbor, -currColor,
                         graph, color)) {
                    return false;
                }
            }
            else if (color[neighbor] == currColor) {
                return false;
            }
        }

        return true;
    }
}