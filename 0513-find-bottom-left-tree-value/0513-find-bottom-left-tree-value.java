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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node = root;

        while (!queue.isEmpty()) {

            node = queue.poll();

            // Push right first
            if (node.right != null) {
                queue.offer(node.right);
            }

            // Push left after
            if (node.left != null) {
                queue.offer(node.left);
            }
        }

        return node.val;
    }
}