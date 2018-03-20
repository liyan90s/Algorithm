/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time: O(n^2), Space: O(1)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        int n = inorder.length;
        return helper(inorder, 0, n - 1, postorder, 0, n - 1);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRoot = i;
                break ;
            }
        }
        int numLeftNodes = inRoot - inStart;
        
        root.left = helper(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numLeftNodes - 1);
        root.right = helper(inorder, inRoot + 1, inEnd, postorder, postStart + numLeftNodes, postEnd - 1);
        
        return root;
    }
}