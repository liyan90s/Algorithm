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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        
        int n = preorder.length;
        return helper(preorder, 0, n - 1, inorder, 0, n - 1);
    }
    
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inRoot = i;
                break ;
            }
        }
        int numLeftNodes = inRoot - inStart;
        
        root.left = helper(preorder, preStart + 1, preStart + numLeftNodes, inorder, inStart, inRoot - 1);
        root.right = helper(preorder, preStart + numLeftNodes + 1, preEnd, inorder, inRoot + 1, inEnd);
        
        return root;
    }
}