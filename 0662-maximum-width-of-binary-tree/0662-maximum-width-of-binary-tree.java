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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> widthQueue=new LinkedList<>();
        widthQueue.offer(new Pair(root,0));

        int maxWidth=0;

        while(!widthQueue.isEmpty()){
            int size=widthQueue.size();
            int start=0;
            int minIndex=widthQueue.peek().index;
            int end=0;

            for(int i=0;i<size;i++){
                Pair cur=widthQueue.poll();
                TreeNode node=cur.node;
                int index=cur.index;
                
                int currentIndex=index-minIndex;
                if(i==0)start=currentIndex;
                end=currentIndex;

                if(node.left != null){
                    widthQueue.offer(new Pair(node.left,2*currentIndex+1));
                }
                if(node.right != null){
                    widthQueue.offer(new Pair(node.right,2*currentIndex+2));
                }
            }
            maxWidth=Math.max(maxWidth,(end-start)+1);
        }
        return maxWidth;
    }
}