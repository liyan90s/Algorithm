public class Solution {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int firstIndex = find(A, target);
        if (firstIndex == 0) {
            return 0;
        } else if (firstIndex == A.length) {
            return A.length - 1;
        } else {
            if (target - A[firstIndex - 1] < A[firstIndex] - target) {
                return firstIndex - 1;
            } else {
                return firstIndex;
            }
        }
    }
    
    public int find(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (A[mid] == target) {
                return mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }
}