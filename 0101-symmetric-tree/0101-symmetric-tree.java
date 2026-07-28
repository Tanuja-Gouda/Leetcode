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
    public boolean isSymmetric(TreeNode root) {
        return find(root.left,root.right);
    }

    private boolean find(TreeNode Left,TreeNode Right){
        if(Left == null && Right == null){
            return true;
        }

        if(Left==null || Right==null){
            return false;
        }

        if(Left.val != Right.val){
            return false;
        }

        return find(Left.left,Right.right) && find(Left.right,Right.left);
    }
}

















    //     return isMirror(root.left, root.right);
    // }

    // private boolean isMirror(TreeNode left, TreeNode right) {
    //     if (left == null && right == null) {
    //         return true;
    //     }

    //     if (left == null || right == null) {
    //         return false;
    //     }

    //     if (left.val != right.val) {
    //         return false;
    //     }

    //     return isMirror(left.left, right.right) &&
    //            isMirror(left.right, right.left);