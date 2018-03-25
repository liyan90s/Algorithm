public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int row = 0, col = matrix[0].length - 1;
        int res = 0;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                res++;
                col--;
                row++;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        
        return res;
    }
}