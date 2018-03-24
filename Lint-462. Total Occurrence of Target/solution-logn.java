public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        if (A == null || A.length == 0 || target < A[0] || target > A[A.length - 1]) {
            return 0;
        }
        
        int leftBound = findLeft(A, target);
        int rightBound = findRight(A, target);
        if (leftBound == -1) {
            return 0;
        } else {
            return rightBound - leftBound + 1;
        }
    }
    
    public int findLeft(int[] nums, int target) {
        int beg = 0, end = nums.length - 1;
        while (beg + 1 < end) {
            int mid = beg + (end - beg) / 2;
            
            if (nums[mid] >= target) {
                end = mid;
            } else {
                beg = mid;
            }
        }
        
        if (nums[beg] == target) {
            return beg;
        }  else if (nums[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
    
    public int findRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}