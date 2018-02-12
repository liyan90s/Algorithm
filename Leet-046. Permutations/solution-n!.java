class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, new ArrayList<>());
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, List<Integer> perm) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return ;
        } 
        
        for (int i = 0; i < nums.length; i++) {
            if (perm.contains(nums[i])) {
                continue ;
            }
            
            perm.add(nums[i]);
            dfs(nums, res, perm);
            perm.remove(perm.size() - 1); // java ArrayList use this method: remove(index) to remove !!
        }
    }
}