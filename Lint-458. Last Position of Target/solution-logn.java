public class Solution {
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                if (mid == nums.length - 1) {
                    return mid;
                } else if (nums[mid + 1] == target) { 
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}