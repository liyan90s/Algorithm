class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        
        return i - 1;
    }
}