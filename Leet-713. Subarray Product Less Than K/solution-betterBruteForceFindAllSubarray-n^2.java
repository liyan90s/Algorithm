class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            int product = 1;
            for (int end = start; end < nums.length; end++) {
                if (product > Integer.MAX_VALUE / nums[end]) {
                    break ;
                }
                
                product *= nums[end];
                if (product < k) {
                    res++;
                }
            }
        }
        
        return res;
    }
}