// Time: O((mn)^2), Space: O(mn)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] areas = new int[rows][cols];
        
        // 1st, use areas[][] to store the rectangle sum at every position (i, j) with another vertice to be at (0, 0)
        // Note that areas[i][j] does NOT represent every rectangle in the matrix, since this rectangle has a fixed vertice at (0, 0)
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                areas[i][j] = matrix[i][j];
                if (i - 1 >= 0) {
                    areas[i][j] += areas[i - 1][j];
                }
                
                if (j - 1 >= 0) {
                    areas[i][j] += areas[i][j - 1];
                }
                
                if (i - 1 >= 0 && j - 1 >= 0) {
                    areas[i][j] -= areas[i - 1][j - 1];
                }
            }
        }
        
        // 2nd, find every rectangle and keep updating the res if area <= k
        int res = Integer.MIN_VALUE;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int c1 = 0; c1 < cols; c1++) {
                for (int r2 = r1; r2 < rows; r2++) {
                    for (int c2 = c1; c2 < cols; c2++) {
                        int area = areas[r2][c2];
                        
                        if (r1 - 1 >= 0) {
                            area -= areas[r1 - 1][c2];
                        }
                        
                        if (c1 - 1 >= 0) {
                            area -= areas[r2][c1 - 1];
                        }
                        
                        if (r1 - 1 >= 0 && c1 - 1 >= 0) {
                            area += areas[r1 - 1][c1 - 1];
                        }
                        
                        if (area <= k) {
                            res = Math.max(res, area);
                        }
                    }
                }
            }
        }
        
        return res;
    }
}