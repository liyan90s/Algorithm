// Worst case is nearly all of the elements are equal, then it will take O(n)
class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return min;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[left]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            } else {
                min = Math.min(min, nums[left]);
                left++;
            }
        }
        
        return min;
    }
}