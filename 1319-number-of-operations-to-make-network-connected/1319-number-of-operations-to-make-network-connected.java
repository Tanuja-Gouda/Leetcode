class Solution {

    public int makeConnected(int n, int[][] connections) {

        if (connections.length < n - 1) {
            return -1;
        }

        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            int parentU = find(u, parent);
            int parentV = find(v, parent);

            if (parentU != parentV) {
                parent[parentU] = parentV;
                components--;
            }
        }

        return components - 1;
    }

    private int find(int node, int[] parent) {

        if (parent[node] == node) {
            return node;
        }

        return parent[node] =
                find(parent[node], parent);
    }
}