public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[left]) {
                res = Math.min(res, nums[left]);
                left = mid;
            } else if (nums[mid] < nums[left]) {
                res = Math.min(res, nums[mid]);
                right = mid;
            } else {
                res = Math.min(res, nums[left]);
                left++;
            }
        }
        
        return Math.min(res, Math.min(nums[left], nums[right]));
    }
}