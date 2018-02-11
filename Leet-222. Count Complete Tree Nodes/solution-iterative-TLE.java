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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            res++;
            
            if (node.left != null) {
                q.add(node.left);
            }
            
            if (node.right != null) {
                q.add(node.right);
            }
        }
        
        return res;
    }
}