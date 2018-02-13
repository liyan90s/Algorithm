class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        dfs(nums, res, 0);
        return res;
    }
    
    public void dfs(int[] nums, List<List<Integer>> res, int swapIdx) {
        if (swapIdx == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int val : nums) {
                permutation.add(val);
            }
            res.add(permutation);
            return ;
        }
        
        for (int i = swapIdx; i < nums.length; i++) {
            if (noSwap(nums, swapIdx, i)) {
                continue ;
            }
            
            swap(nums, swapIdx, i);
            dfs(nums, res, swapIdx + 1);
            swap(nums, swapIdx, i);
        }
    }
    
    public boolean noSwap(int[] nums, int left, int right) {
        while (left < right) {
            if (nums[left] == nums[right]) {
                return true;
            }
            left++;
        }
        
        return false;
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}