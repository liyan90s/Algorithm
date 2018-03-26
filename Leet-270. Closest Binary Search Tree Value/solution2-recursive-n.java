/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time: O(n), worst case is that all the nodes are in one direction, either all in left, or all in right
// Time: O(logn), if tree is balanced
class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        
        int[] res = {root.val};
        helper(root, target, res);
        
        return res[0];
    }
    
    public void helper(TreeNode node, double target, int[] res) {
        if (node == null) {
            return;
        }
        
        if (Math.abs(node.val - target) < Math.abs(res[0] - target)) {
            res[0] = node.val;
        }
        
        if (node.val < target) {
            helper(node.right, target, res);
        } else {
            helper(node.left, target, res);
        }
    }
}