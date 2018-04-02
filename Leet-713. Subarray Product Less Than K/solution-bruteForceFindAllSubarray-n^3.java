class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        
        int res = 0;
        for (int start = 0; start < nums.length; start++) {
            for (int end = start; end < nums.length; end++) {
                long product = 1;
                for (int i = start; i <= end; i++) {
                    if (product > Integer.MAX_VALUE / nums[i]) {
                        break ;
                    }
                    product *= nums[i];
                }
                
                if (product < k) {
                    res++;
                }
            }
        }
        
        return res;
    }
}