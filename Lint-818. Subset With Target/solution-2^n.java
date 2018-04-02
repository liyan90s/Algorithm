public class Solution {
    /**
     * @param nums: the array
     * @param target: the target
     * @return: the number of subsets which meet the following conditions
     */
    public long subsetWithTarget(int[] nums, int target) {
        // Write you code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, target, res, new ArrayList<>(), 0);
        
        return res.size() - 1;
    }
    
    public void dfs(int[] nums, int target, List<List<Integer>> res, List<Integer> subset, int startIdx) {
        if (startIdx <= nums.length) {
            res.add(new ArrayList<>(subset));
        }
        
        for (int i = startIdx; i < nums.length; i++) {
            if (subset.isEmpty() && nums[i] * 2 < target || !subset.isEmpty() && subset.get(0) + nums[i] < target) {
                subset.add(nums[i]);
                dfs(nums, target, res, subset, i + 1);
                subset.remove(subset.size() - 1);
            }
        }
    }
}