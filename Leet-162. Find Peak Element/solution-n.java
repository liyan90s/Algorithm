class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int idx = 0;
        while (idx < nums.length - 1 && nums[idx] < nums[idx + 1]) {
            idx++;
        }
        
        return idx;
    }
}