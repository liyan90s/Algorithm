class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int res = 0;
        int[] memo = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            memo[i] = memo[i - 1] + nums[i - 1];
            for (int j = 0; j < i; j++) {
                int sum = memo[i] - memo[j];
                if (sum == k) {
                    res++;
                }
            }
        }
        
        return res;
    }
}