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
        Queue<TreeNode> queue= new LinkedList<TreeNode>();
        List<List<Integer>> list=new LinkedList<List<Integer>>();

        if(root==null){
            return list;
        }
        queue.offer(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> subList=new LinkedList<Integer>();
            
            for(int i=0;i<size;i++){
                TreeNode cur=queue.poll();
                subList.add(cur.val);

                if(cur.left != null){
                    queue.offer(cur.left);
                }

                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }

            list.add(subList);
        }
        return list;
    }
}