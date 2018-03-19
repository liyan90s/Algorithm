class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0;
        for (int val : nums) {
            if (i < 2 || val > nums[i - 2]) {
                nums[i] = val;
                i++;
            }
        }
        
        return i;
    }
}