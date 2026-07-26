class Solution {
    int count;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> pre=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            pre.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            pre.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] vis=new int[n];
        count=0;

        for(int i=0;i<n;i++){
            if(vis[i]==0){
                if(!dfs(i,pre,vis)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node,List<List<Integer>> adj,int[] vis){
        vis[node]=1;
        for(int neigh:adj.get(node)){
            if(vis[neigh]==0){
                if(!dfs(neigh,adj,vis)){
                    return false;
                }
            }
            if(vis[neigh]==1){
                return false;
            }
        }
        vis[node]=2;
        return true;
    }
}

























    //     List<List<Integer>> adj = new ArrayList<>();

    //     for (int i = 0; i < numCourses; i++) {
    //         adj.add(new ArrayList<>());
    //     }

    //     for (int[] pre : prerequisites) {
    //         adj.get(pre[1]).add(pre[0]);
    //     }

    //     int[] visited = new int[numCourses];
    //     // 0 = Unvisited
    //     // 1 = Visiting
    //     // 2 = Visited

    //     for (int course = 0; course < numCourses; course++) {

    //         if (visited[course] == 0) {

    //             if (hasCycle(course, adj, visited)) {
    //                 return false;
    //             }
    //         }
    //     }

    //     return true;
    // }

    // private boolean hasCycle(int node,
    //                          List<List<Integer>> adj,
    //                          int[] visited) {

    //     visited[node] = 1;

    //     for (int neighbor : adj.get(node)) {

    //         if (visited[neighbor] == 1) {
    //             return true;
    //         }

    //         if (visited[neighbor] == 0) {

    //             if (hasCycle(neighbor, adj, visited)) {
    //                 return true;
    //             }
    //         }
    //     }

    //     visited[node] = 2;

    //     return false;