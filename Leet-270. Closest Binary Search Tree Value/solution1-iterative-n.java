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
        
        int res = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(res - target)) {
                res = root.val;
            }
            
            root = root.val < target ? root.right : root.left;
        }
        
        return res;
    }
}