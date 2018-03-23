public class Solution {
    /**
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] == target) {
                return true;
            } else if (A[mid] > A[left]) {
                if (A[left] <= target && target < A[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (A[mid] < A[left]) {
                if (A[mid] < target && target <= A[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            } else {
                left++;
            }
        }
        
        if (A[left] == target || A[right] == target) {
            return true;
        }
        
        return false;
    }
}