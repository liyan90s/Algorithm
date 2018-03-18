class Solution {
    public int[][] generateMatrix(int n) {        
        if (n <= 0) {
            return new int[][] {};
        }
        
        int[][] res = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int num = 1;
        
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                res[top][j] = num++;
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                res[i][right] = num++;
            }
            right--;
            
            // this check for general, when required a m * n matrix to return
            if (left > right || top > bottom) {
                break ;
            }
            
            for (int j = right; j >= left; j--) {
                res[bottom][j] = num++;
            }
            bottom--;
            
            for (int i = bottom; i >= top; i--) {
                res[i][left] = num++;
            }
            left++;
        }
        
        return res;
    }
}