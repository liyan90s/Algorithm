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
        if (root == null) {
            return 0;
        }
        
        PriorityQueue<TreeNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            pq.offer(node);
            
            if (node.left != null) {
                q.add(node.left);
            }
            
            if (node.right != null) {
                q.add(node.right);
            }
        }
        
        int count = 0;
        while (!pq.isEmpty()) {
            TreeNode node = pq.poll();
            count++;
            
            if (count == k) {
                return node.val;
            }
        }
        
        return 0;
    }
}