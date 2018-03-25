// Time: O(nlogn), Space: O(1)
class Solution {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (count(nums, mid) > mid) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (count(nums, left) > left) {
            return left;
        } else {
            return right;
        }
    }
    
    public int count(int[] nums, int mid) {
        int count = 0;
        for (int val : nums) {
            if (val <= mid) {
                count++;
            }
        }
        
        return count;
    }
}