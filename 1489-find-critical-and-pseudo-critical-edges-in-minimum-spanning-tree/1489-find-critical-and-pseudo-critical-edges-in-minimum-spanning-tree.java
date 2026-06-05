class Solution {

    class DSU {

        int[] parent;

        DSU(int n) {

            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {

            if (parent[x] == x) {
                return x;
            }

            return parent[x] =
                    find(parent[x]);
        }

        boolean union(int a, int b) {

            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return false;
            }

            parent[pa] = pb;

            return true;
        }
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(
            int n,
            int[][] edges) {

        int m = edges.length;

        int[][] newEdges =
                new int[m][4];

        for (int i = 0; i < m; i++) {

            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i;
        }

        Arrays.sort(newEdges,
                (a, b) ->
                        a[2] - b[2]);

        int mstWeight =
                kruskal(n,
                        newEdges,
                        -1,
                        -1);

        List<Integer> critical =
                new ArrayList<>();

        List<Integer> pseudo =
                new ArrayList<>();

        for (int i = 0; i < m; i++) {

            if (kruskal(n,
                    newEdges,
                    i,
                    -1)
                    > mstWeight) {

                critical.add(
                        newEdges[i][3]);
            }

            else if (
                    kruskal(n,
                            newEdges,
                            -1,
                            i)
                            == mstWeight) {

                pseudo.add(
                        newEdges[i][3]);
            }
        }

        return Arrays.asList(
                critical,
                pseudo);
    }

    private int kruskal(int n,
                        int[][] edges,
                        int skipEdge,
                        int forceEdge) {

        DSU dsu = new DSU(n);

        int weight = 0;
        int edgesUsed = 0;

        if (forceEdge != -1) {

            int[] edge =
                    edges[forceEdge];

            if (dsu.union(edge[0],
                    edge[1])) {

                weight += edge[2];
                edgesUsed++;
            }
        }

        for (int i = 0;
             i < edges.length;
             i++) {

            if (i == skipEdge) {
                continue;
            }

            int[] edge = edges[i];

            if (dsu.union(edge[0],
                    edge[1])) {

                weight += edge[2];
                edgesUsed++;
            }
        }

        return edgesUsed
                == n - 1
                ? weight
                : Integer.MAX_VALUE;
    }
}