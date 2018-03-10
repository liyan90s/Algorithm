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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int[] res = { Integer.MIN_VALUE };
        helper(root, res);
        
        return res[0];
    }
    
    public int helper(TreeNode root, int[] res) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(0, helper(root.left, res));
        int right = Math.max(0, helper(root.right, res));
        res[0] = Math.max(res[0], left + right + root.val);
        
        return root.val + Math.max(left, right);
    }
}

/*
 * res[0] is the value which recording whether this current root is the final root, so we use left + right + node.val. 
 * But to the upper layer(after return statement), we cannot choose both left and right brunches, so we need to 
 * select the larger one, so we use max(left, right) + node.val to prune the lower brunch.
 */