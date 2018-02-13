class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());     // for empty subset
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), 0, new boolean[nums.length]);
        
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> subset, int startIdx, boolean[] used) {
        for (int i = startIdx; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue ;
            }
            
            used[i] = true;
            subset.add(nums[i]);
            res.add(new ArrayList<>(subset));            
            dfs(nums, res, subset, i + 1, used);
            subset.remove(subset.size() - 1);
            used[i] = false;
        }
    }
}