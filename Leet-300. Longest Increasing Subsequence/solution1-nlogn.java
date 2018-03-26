class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int len = 1;
        
        for (int i = 1; i < n; i++) {
            int insertIndex = findInsertPosition(dp, len, nums[i]);
            dp[insertIndex] = nums[i];
            
            if (insertIndex == len) {
                len++;
            }
        }
        
        return len;
    }
    
    public int findInsertPosition(int[] nums, int len, int target) {
        int left = 0, right = len - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (target <= nums[left]) {
            return left;
        } else if (target <= nums[right]) {
            return right;
        } else {
            return right + 1;
        }
    }
}