class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE;
        }
        
        int left = 0, right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[left]) {
                min = Math.min(min, nums[left]);
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            } else {
                min = Math.min(min, nums[mid]);
                left++;
            }
        }
        
        return min;
    }
}