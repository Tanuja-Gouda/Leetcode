/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonNode(root,p,q);
    }

    private TreeNode commonNode(TreeNode cur,TreeNode node1,TreeNode node2){
        if(cur==null || cur.val==node1.val || cur.val==node2.val){
            return cur;
        }

        TreeNode left=commonNode(cur.left,node1,node2);
        TreeNode right=commonNode(cur.right,node1,node2);

        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return cur;
        }
    }
}