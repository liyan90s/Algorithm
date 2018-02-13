class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), new boolean[nums.length]);
        
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            res.add(new ArrayList<>(permutation));
            return ;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue ;
            }
            
            used[i] = true;
            permutation.add(nums[i]);
            dfs(nums, res, permutation, used);
            permutation.remove(permutation.size() - 1);
            used[i] = false;
        }
    }
}