public class Solution {
    /**
     * @param A: an integer array
     * @param target: An integer
     * @param k: An integer
     * @return: an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        if (A == null || A.length == 0 || k < 1 || A.length < k) {
            return new int[] {};
        }
        
        int[] res = new int[k];
        int left = 0, right = A.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        int count = 0;
        while (left >= 0 && right < A.length && count < k) {
            if (Math.abs(target - A[left]) <= Math.abs(target - A[right])) {
                res[count] = A[left];
                left--;
            } else {
                res[count] = A[right];
                right++;
            }
            count++;
        }
        
        while (left >= 0 && count < k) {
            res[count] = A[left];
            left--;
            count++;
        }
        
        while (right < A.length && count < k) {
            res[count] = A[right];
            right++;
            count++;
        }
        
        return res;
    }
}