// Time: O(n), Space: O(1)
// this method can be applied to remove duplicates such that each element exist at most k times
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = 0;
        for (int val : nums) {
            if (i < 1 || val > nums[i - 1]) {   // for k times, just change to -> if (i < k || val > nums[i - k])
                nums[i] = val;
                i++;
            }
        }
        
        return i;
    }
}