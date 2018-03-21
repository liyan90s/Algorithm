public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 1;
        while (i < nums.length && nums[i] > nums[i - 1]) {
            i++;
        }
        
        return nums[i - 1];
    }
}