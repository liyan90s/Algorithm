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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return Integer.MAX_VALUE;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                count++;
                if (count == k) {
                    return root.val;
                }
                
                root = root.right;
            }
        }
        
        return Integer.MAX_VALUE;
    }
}