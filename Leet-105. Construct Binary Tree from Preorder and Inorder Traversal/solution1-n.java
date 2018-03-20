/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time: O(n), Space: O(n) for the Map
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, n - 1, inorder, 0, n - 1, map);
    }
    
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numLeftNodes = inRoot - inStart;
        
        root.left = helper(preorder, preStart + 1, preStart + numLeftNodes, inorder, inStart, inRoot - 1, map);
        root.right = helper(preorder, preStart + numLeftNodes + 1, preEnd, inorder, inRoot + 1, inEnd, map);
        
        return root;
    }
}