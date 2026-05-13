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

    public void rightView(TreeNode root, List<Integer> list, int currentDepth){
        if(root == null){
            return;
        }

        if(currentDepth == list.size()){
            list.add(root.val);
        }

        rightView(root.right, list,currentDepth+1);
        rightView(root.left, list, currentDepth+1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        rightView(root,list,0);
        return list;
    }
}