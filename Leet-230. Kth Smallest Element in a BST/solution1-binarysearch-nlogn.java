/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time: O(nlogn)
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return Integer.MAX_VALUE;
        }
        
        int countLeft = countNodes(root.left);
        if (k == countLeft + 1) {
            return root.val;
        } else if (k <= countLeft) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - countLeft - 1);
        }
    }
    
    public int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
}