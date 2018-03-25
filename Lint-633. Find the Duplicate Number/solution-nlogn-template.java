public class Solution {
    /**
     * @param nums: an array containing n + 1 integers which is between 1 and n
     * @return: the duplicate one
     */
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int cnt = count(nums, mid);
            
            if (cnt <= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (count(nums, left) > left) {
            return left;
        }
        
        return right;
    }
    
    public int count(int[] nums, int mid) {
        int res = 0;
        for (int val : nums) {
            if (val <= mid) {
                res++;
            }
        }
        
        return res;
    }
}