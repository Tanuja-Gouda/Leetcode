class Solution {

    public boolean isBipartite(int[][] graph) {
        int n=graph.length;

        int[] color=new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1){
            if(check(0,i,color,graph)==false){
                return false;
            }
            }
        }
        return true;        
    }

    private boolean check(int cr,int node,int[] color,int[][] graph){
        color[node]=cr;
        for(int neigh:graph[node]){
            if(color[neigh]==-1){
                if(check(1-cr,neigh,color,graph)==false){
                    return false;
                }
            }else if(color[neigh]==cr){
                return false;
            }
        }
        return true;
    }
}


























    //     int n = graph.length;
    //     int[] color = new int[n];

    //     for (int node = 0; node < n; node++) {

    //         if (color[node] == 0) {

    //             if (!dfs(node, 1, graph, color)) {
    //                 return false;
    //             }
    //         }
    //     }

    //     return true;
    // }

    // private boolean dfs(int node,
    //                     int currColor,
    //                     int[][] graph,
    //                     int[] color) {

    //     color[node] = currColor;

    //     for (int neighbor : graph[node]) {

    //         if (color[neighbor] == 0) {

    //             if (!dfs(neighbor, -currColor,
    //                      graph, color)) {
    //                 return false;
    //             }
    //         }
    //         else if (color[neighbor] == currColor) {
    //             return false;
    //         }
    //     }

    //     return true;