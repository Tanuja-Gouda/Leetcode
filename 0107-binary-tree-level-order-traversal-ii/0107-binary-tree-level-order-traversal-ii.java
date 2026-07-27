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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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

        Collections.reverse(ans);
        return ans;
    }
}