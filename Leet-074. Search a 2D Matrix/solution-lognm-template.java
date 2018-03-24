public class Solution {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        if (matrix[0][0] > target || matrix[m - 1][n - 1] < target) {
            return false;
        }
        
        int left = 0, right = m - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        int row = -1;
        if (target >= matrix[right][0]) {
            row = right;
        } else {
            row = left;
        }
    
        left = 0;
        right = n - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        
        if (matrix[row][left] == target || matrix[row][right] == target) {
            return true;
        }
        
        return false;
    }
}