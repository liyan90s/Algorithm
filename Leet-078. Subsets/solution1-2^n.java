class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, new ArrayList<>(), 0);
        
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> subset, int startIdx) {
        if (startIdx <= nums.length) {
            res.add(new ArrayList<>(subset));
        }
        
        for (int i = startIdx; i < nums.length; i++) {                        
            subset.add(nums[i]);            
            dfs(nums, res, subset, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}