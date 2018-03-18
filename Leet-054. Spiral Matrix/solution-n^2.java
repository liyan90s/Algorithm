class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int left = 0, right = matrix[0].length - 1;
        int top = 0, bottom = matrix.length - 1;
        
        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            
            // check if operation should end at this point
            if (left > right || top > bottom) {
                break ;
            }
            
            for (int j = right; j >= left; j--) {
                res.add(matrix[bottom][j]);
            }                              
            bottom--;  
            
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }                                
            left++;
        }
        
        return res;
    }
}