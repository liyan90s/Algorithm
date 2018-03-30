class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        
        int[] res = {0};
        dfs(nums, target, 0, res, 0, 0);
        return res[0];
    }
    
    public void dfs(int[] nums, int target, int startIndex, int[] res, int sum, int used) {
        if (used == 3) {
            if (sum < target) {
                res[0]++;
            }
            
            return ;
        }
        
        for (int i = startIndex; i < nums.length; i++) {
            dfs(nums, target, i + 1, res, sum + nums[i], used + 1);
        }
    }
}