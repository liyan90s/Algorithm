// Time: O(logmn), but need to worry about the overflow when doing (m * n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;          // take care for the overflow, use solution1 to avoid it
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            int row = mid / n, col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
    }
}