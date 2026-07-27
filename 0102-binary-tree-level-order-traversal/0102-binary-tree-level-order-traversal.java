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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return ans;
        }

        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> subList=new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode curNode=q.poll();
                subList.add(curNode.val);
                if(curNode.left != null){
                    q.offer(curNode.left);
                }
                if(curNode.right != null){
                    q.offer(curNode.right);
                }
            }
            ans.add(subList);
        } 

        return ans;
    }
}














       // Queue<TreeNode> queue= new LinkedList<TreeNode>();
        // List<List<Integer>> list=new LinkedList<List<Integer>>();

        // if(root==null){
        //     return list;
        // }
        // queue.offer(root);

        // while(!queue.isEmpty()){
        //     int size=queue.size();
        //     List<Integer> subList=new LinkedList<Integer>();
            
        //     for(int i=0;i<size;i++){
        //         TreeNode cur=queue.poll();
        //         subList.add(cur.val);

        //         if(cur.left != null){
        //             queue.offer(cur.left);
        //         }

        //         if(cur.right != null){
        //             queue.offer(cur.right);
        //         }
        //     }

        //     list.add(subList);
        // }
        // return list;