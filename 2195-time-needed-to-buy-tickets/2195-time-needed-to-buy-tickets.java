class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        int n = tickets.length;
        int[] result = new int[n];
        
        for(int i=0;i<n;i++){
            q.offer(i);
        }

        int time = 0;
        while(!q.isEmpty()){
            int ticket = q.poll();
            time++;
            tickets[ticket]--;
            if(ticket==k && tickets[ticket]==0){
                return time;
            }
            if(tickets[ticket]>0){
                q.offer(ticket);
            }
        }
        return -1;
    }
}