class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, res, new ArrayList<>());
        
        return res;
    }
    
    public void dfs(int[] nums, int target, int sum, int startIdx, List<List<Integer>> res, List<Integer> list) {
        if (sum > target) {
            return ;
        }
        
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return ;
        }
        
        for (int i = startIdx; i < nums.length; i++) {
            // i > startIdx means nums[i - 1] hasn't been added into the list,
            // because after the last run, the nums[i - 1] is removed from the list.
            // so no need to use an extra boolean array
            if (i > startIdx && nums[i] == nums[i - 1]) { 
                continue ;
            }
            
            list.add(nums[i]);
            dfs(nums, target, sum + nums[i], i + 1, res, list);
            list.remove(list.size() - 1);
        }
    }
}