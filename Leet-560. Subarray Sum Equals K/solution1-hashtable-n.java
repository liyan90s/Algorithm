class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        
        for (int val : nums) {
            sum += val;
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}