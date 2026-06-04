class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {

            int u = dislike[0];
            int v = dislike[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] color = new int[n + 1];

        for (int person = 1; person <= n; person++) {

            if (color[person] == 0) {

                if (!dfs(person, 1, adj, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        int currColor,
                        List<List<Integer>> adj,
                        int[] color) {

        color[node] = currColor;

        for (int neighbor : adj.get(node)) {

            if (color[neighbor] == 0) {

                if (!dfs(neighbor, -currColor,
                         adj, color)) {
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