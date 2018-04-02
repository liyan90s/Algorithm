class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, -1);  // pre-populate, since the result subarray started AFTER the previous sum
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                res = Math.max(res, i - preSum.get(sum - k));
            }
            
            if (!preSum.containsKey(sum)) {
                preSum.put(sum, i);
            }
        }
        
        return res;
    }
}