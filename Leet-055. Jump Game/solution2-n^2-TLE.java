class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        
        boolean[] memo = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = false;
        }
        
        memo[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            int furthest = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (memo[j]) {
                    memo[i] = true;
                    break ;
                }
            }
        }
        
        return memo[0];
    }
}