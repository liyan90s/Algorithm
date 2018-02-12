class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, 0);
        
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, int swapIdx) {
        if (swapIdx == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int val : nums) {
                list.add(val);
            }
            
            res.add(list);
            return ;
        }
        
        for (int i = swapIdx; i < nums.length; i++) {
            swap(nums, swapIdx, i);
            dfs(nums, res, swapIdx + 1);
            swap(nums, swapIdx, i);
        }
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}