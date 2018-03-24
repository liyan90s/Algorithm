public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || A.length < k) {
            return new int[] {};
        }
        
        int[] res = new int[k];
        int index = binarySearch(A, target);
        
        int count = 0;
        int left = index - 1, right = index;
        while (left >= 0 && right < A.length && count < k) {
            if (Math.abs(A[left] - target) <= Math.abs(A[right] - target)) {
                res[count] = A[left];
                left--;
            } else {
                res[count] = A[right];
                right++;
            }
            count++;
        }
        
        while (left >= 0 && count < k) {
            res[count++] = A[left--];
        }
        
        while (right < A.length && count < k) {
            res[count++] = A[right++];
        }
        
        return res;
    }
    
    public int binarySearch(int[] A, int target) {
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
        
        if (target <= A[left]) {
            return 0;   // if target <= A[left], must be either < A[0], or == A[0]
        } else {
            return right;
        }
    }
}