class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int end = 0;
        int count = 0;
        int maxLen = 0;
        for (int start = 0; start < nums.length; start++) {
            while (end < nums.length && count <= 1) {
                if (nums[end] == 0) {
                    count++;
                }
                
                end++;
            }
            
            if (count == 2) {
                maxLen = Math.max(maxLen, end - start - 1);
            } else {
                return Math.max(maxLen, nums.length - start);
            }
            
            if (nums[start] == 0) {
                count--;
            }
        }
        
        return maxLen;
    }
}