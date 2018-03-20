/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time: O(n), Space: O(n)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        
        int n = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(inorder, 0, n - 1, postorder, 0, n - 1, map);
    }
    
    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> map) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int numLeftNodes = inRoot - inStart;
        
        root.left = helper(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numLeftNodes - 1, map);
        root.right = helper(inorder, inRoot + 1, inEnd, postorder, postStart + numLeftNodes, postEnd - 1, map);
        
        return root;
    }
}