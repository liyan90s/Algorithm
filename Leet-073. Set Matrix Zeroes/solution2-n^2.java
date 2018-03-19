// Time: O(n * m), Space: O(n + m)
class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        
        HashSet<Integer> zeroRow = new HashSet<>();
        HashSet<Integer> zeroCol = new HashSet<>();
        
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroRow.add(i);
                    zeroCol.add(j);
                }
            }
        }
        
        for (int row : zeroRow) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }
        
        for (int col : zeroCol) {
            for (int i = 0; i < m; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}