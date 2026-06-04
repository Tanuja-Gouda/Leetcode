class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int node = 0; node < n; node++) {

            for (int neighbor : graph[node]) {

                reverseGraph.get(neighbor).add(node);
                indegree[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            safeNodes.add(node);

            for (int prev : reverseGraph.get(node)) {

                indegree[prev]--;

                if (indegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}