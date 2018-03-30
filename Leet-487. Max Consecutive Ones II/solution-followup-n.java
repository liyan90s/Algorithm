class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int prev = -1, curr = 0;
        int res = 0;
        for (int val : nums) {
            if (val == 0) {
                prev = curr;
                curr = 0;
            } else {
                curr++;
            }
            
            res = Math.max(res, prev + 1 + curr);
        }
        
        return res;
    }
}