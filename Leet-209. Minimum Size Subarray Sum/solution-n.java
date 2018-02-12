class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int sum = 0;
        int right = 0;
        int minLen = nums.length + 1;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && sum < s) {
                sum += nums[right];
                right++;
            }
            
            if (sum >= s) {
                minLen = Math.min(minLen, right - left);
            }
            
            sum -= nums[left];
        }
        
        return minLen > nums.length ? 0 : minLen;
    }
}