class Solution {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int m=rooms.size();
        boolean[] entered=new boolean[m];

        dfs(0,rooms,entered);

        for(int i=0;i<m;i++){
            if(entered[i]==false){
                return false;
            }
        }
        return true;
    }

    private void dfs(int room, List<List<Integer>> rooms, boolean[] entered){
        entered[room]=true;

        for(int key:rooms.get(room)){
            if(entered[key] != true){
                dfs(key,rooms,entered);
            }
        }
    }
}


























// boolean[] visited = new boolean[rooms.size()];

//         dfs(0, rooms, visited);

//         for (boolean room : visited) {
//             if (!room) {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private void dfs(int room,
//                      List<List<Integer>> rooms,
//                      boolean[] visited) {

//         visited[room] = true;

//         for (int key : rooms.get(room)) {

//             if (!visited[key]) {
//                 dfs(key, rooms, visited);
//             }
//         }