class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        
        int right = 0;
        int res = 0;
        int product = 1;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] * product < k) {
                product *= nums[right];
                right++;
            }
            
            if (right == left) {
                right++;
                product = 1;
            } else {
                res += right - left;
                product /= nums[left];
            }
        }
        
        return res;
    }
}