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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        dfs(root, res, 0);
        return res;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> res, int height) {
        if (root == null) {
            return ;
        }
        
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        
        res.get(height).add(root.val);
        dfs(root.left, res, height + 1);
        dfs(root.right, res, height + 1);
    }
}