public class Solution {
    /*
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    public double maxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        double left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int val : nums) {
            if (val < left) {
                left = val;
            }
            
            if (val > right) {
                right = val;
            }
        }
        
        while (right - left >= 1e-10) {
            double mid = left + (right - left) / 2.0;
            
            if (checkValid(nums, mid, k)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public boolean checkValid(int[] nums, double mid, int k) {
        double[] sum = new double[nums.length + 1];
        sum[0] = 0;
        
        double minPre = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + (nums[i - 1] - mid);
            
            if (i >= k && sum[i] - minPre >= 0) {
                return true;
            }
            
            if (i >= k) {
                minPre = Math.min(minPre, sum[i - k + 1]);
            }
        }
        
        return false;
    }
}