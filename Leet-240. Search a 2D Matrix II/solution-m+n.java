class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length, n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            
            if (val < target) {
                row++;
            } else if (val > target) {
                col--;
            } else {
                return true;
            }
        }
        
        return false;
    }
}