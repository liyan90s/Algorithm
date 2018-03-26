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
        
        return helper(root, target, root.val);
    }
    
    public int helper(TreeNode node, double target, int res) {
        if (node == null) {
            return res;
        }
        
        if (Math.abs(node.val - target) < Math.abs(res - target)) {
            res = node.val;
        }
        
        if (node.val < target) {
            res = helper(node.right, target, res);
        } else {
            res = helper(node.left, target, res);
        }
        
        return res;
    }
}