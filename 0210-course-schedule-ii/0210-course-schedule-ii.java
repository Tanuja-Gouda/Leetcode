class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> pre=new ArrayList<>();
        for(int i=0;i<n;i++){
            pre.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            pre.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Stack<Integer> st=new Stack<>();
        int[] visited=new int[n];
        boolean isPossible=false;

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs(i,pre,visited,st);
            }
        }
        int[] ans=new int[st.size()];
        int j=0;
        while(!st.isEmpty()){
            ans[j++]=st.peek();
            st.pop();
        }
        
        return ans.length==n?ans:new int[0];
    }

    private void dfs(int node,List<List<Integer>> adj,int[] vis,Stack<Integer> st){
        vis[node]=1;
        for(int neigh:adj.get(node)){
            if(vis[neigh]==0){
                dfs(neigh,adj,vis,st);
            }
            if(vis[neigh]==1){
                return;
            }
        }
        vis[node]=2;
        st.push(node);
    }
}
























 // List<List<Integer>> adj = new ArrayList<>();

        // for (int i = 0; i < numCourses; i++) {
        //     adj.add(new ArrayList<>());
        // }

        // int[] indegree = new int[numCourses];

        // for (int[] pre : prerequisites) {

        //     int u = pre[1];
        //     int v = pre[0];

        //     adj.get(u).add(v);
        //     indegree[v]++;
        // }

        // Queue<Integer> q = new LinkedList<>();

        // for (int i = 0; i < numCourses; i++) {
        //     if (indegree[i] == 0) {
        //         q.offer(i);
        //     }
        // }

        // int[] order = new int[numCourses];
        // int index = 0;

        // while (!q.isEmpty()) {

        //     int node = q.poll();
        //     order[index++] = node;

        //     for (int neighbor : adj.get(node)) {

        //         indegree[neighbor]--;

        //         if (indegree[neighbor] == 0) {
        //             q.offer(neighbor);
        //         }
        //     }
        // }

        // return index == numCourses
        //         ? order
        //         : new int[0];