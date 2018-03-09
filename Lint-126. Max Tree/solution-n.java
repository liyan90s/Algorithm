/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        for (int val : A) {
            TreeNode node = new TreeNode(val);
            while (!stack.isEmpty() && node.val > stack.peek().val) {
                node.left = stack.pop();
            }
            
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }
            
            stack.push(node);
        }
        
        TreeNode res = null;
        while (!stack.isEmpty()) {
            res = stack.pop();
        }
        
        return res;
    }
}