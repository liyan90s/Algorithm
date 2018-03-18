class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        return canJumpToEnd(0, nums);
    }
    
    public boolean canJumpToEnd(int start, int[] nums) {
        if (start >= nums.length - 1) {
            return true;
        }
        
        int furthest = Math.min(start + nums[start], nums.length - 1);
        for (int i = start + 1; i <= furthest; i++) {
            if (canJumpToEnd(i, nums)) {
                return true;
            }
        }
        
        return false;
    }
}