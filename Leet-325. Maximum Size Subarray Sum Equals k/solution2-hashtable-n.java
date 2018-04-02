class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                res = Math.max(res, i + 1); // indeed, res = i + 1, don't have to compare
            } else if (preSum.containsKey(sum - k)) {
                res = Math.max(res, i - preSum.get(sum - k));
            }
            
            if (!preSum.containsKey(sum)) {
                preSum.put(sum, i);
            }
        }
        
        return res;
    }
}