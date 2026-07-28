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

    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter=new int[1];
        Diameter(root,diameter);
        return diameter[0];
    }

    private static int Diameter(TreeNode cur,int[] diameter){
        if(cur==null){
            return 0;
        }

        int leftHeight=Diameter(cur.left,diameter);
        int rightHeight=Diameter(cur.right,diameter);

        diameter[0]=Math.max(diameter[0],leftHeight+rightHeight);

        return Math.max(leftHeight,rightHeight)+1;
    }
}










    //     if(root==null){
    //         return 0;
    //     }

    //     int left=findDiameter(root.left, diameter);
    //     int right=findDiameter(root.right, diameter);

    //     diameter[0]=Math.max(diameter[0], left+right);

    //     return Math.max(left,right)+1;
        
    // }

    // public int diameterOfBinaryTree(TreeNode root) {
    //     int[] diameter=new int[1];
    //     findDiameter(root,diameter);
    //     return diameter[0];