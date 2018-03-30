class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return ;
        }
        
        int right = 0;
        for (int left = 0; left < nums.length; left++) {
            while (right < nums.length && nums[right] == 0) {
                right++;
            }
            
            if (right == nums.length) {
                nums[left] = 0;
                continue ;
            }
            
            nums[left] = nums[right];
            right++;
        }
    }
}