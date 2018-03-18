class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        
        int currEnd = 0, furthest = 0;
        int jump = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            
            // check if it can jump to the end, if not, return -1
            if (furthest <= i) {
                return -1;
            }
            
            if (i == currEnd) {
                jump++;
                currEnd = furthest;
                
                if (furthest >= nums.length - 1) {
                    break ;
                }
            }
        }
        
        return jump;
    }
}