class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        return longestLIS(nums, Integer.MIN_VALUE, 0);
    }
    
    public int longestLIS(int[] nums, int prev, int pos) {
        if (pos == nums.length) {
            return 0;
        }
        
        int taken = 0;
        if (nums[pos] > prev) {
            taken = 1 + longestLIS(nums, nums[pos], pos + 1);
        }
        
        int notTaken = longestLIS(nums, prev, pos + 1);
        
        return Math.max(taken, notTaken);
    }
}