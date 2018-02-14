// Time: O(n) = O(n + n/2 + n/4 + n/8 + ...) = O(2n - 1) => O(n)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return Integer.MIN_VALUE;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int pos = partition(nums, left, right);
            if (pos == k - 1) {
                return nums[pos];
            } else if (pos > k - 1) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        
        return Integer.MIN_VALUE;
    }
    
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lo = left + 1;
        int hi = right;
        
        while (lo <= hi) {
            while (lo <= hi && nums[lo] >= pivot) {
                lo++;
            }
            
            while (lo <= hi && nums[hi] <= pivot) {
                hi--;
            }
            
            if (lo <= hi) {
                swap(nums, lo, hi);
                lo++;
                hi--;
            }
        }
        
        swap(nums, left, hi);        
        return hi;
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}