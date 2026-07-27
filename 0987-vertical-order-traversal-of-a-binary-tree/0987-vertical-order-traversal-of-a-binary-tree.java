/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Tuple{
    TreeNode node;
    int col;
    int row;

    Tuple(TreeNode node, int col, int row){
        this.node=node;
        this.col=col;
        this.row=row;
    }
}


class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> ans=new TreeMap<>();

        Queue<Tuple> q=new LinkedList<>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple cur=q.poll();
            TreeNode node=cur.node;
            int col=cur.col;
            int row=cur.row;

            ans.putIfAbsent(col,new TreeMap<>());
            ans.get(col).putIfAbsent(row,new PriorityQueue<>());

            ans.get(col).get(row).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,col-1,row+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right,col+1,row+1));
            }
        }
        List<List<Integer>> finalAns=new ArrayList<>();

        for(TreeMap<Integer,PriorityQueue<Integer>> item:ans.values()){
            List<Integer> list=new ArrayList<>();
            for(PriorityQueue<Integer> pq:item.values()){
                while(!pq.isEmpty()){
                    list.add(pq.poll());
                }
            }
            finalAns.add(list);
        }
        return finalAns;
    }
}