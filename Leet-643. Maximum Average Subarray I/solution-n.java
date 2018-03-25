class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || k < 0 || nums.length < k)  {
            return 0;
        }
        
        double max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k - 1; i++) {
            sum += nums[i];
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            sum += nums[i];
            double avg = (double) sum / k;
            max = Math.max(max, avg);
            sum -= nums[i - k + 1];
        }
        
        return max;
    }
}