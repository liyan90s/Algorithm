// Time: O(mmnlogn), where m = matrix.length, n = matrix[0].length
// Space: O(m)
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        int res = Integer.MIN_VALUE;
        
        for (int left = 0; left < cols; left++) {
            int[] sum = new int[rows];
            for (int right = left; right < cols; right++) {
                for (int i = 0; i < rows; i++) {
                    sum[i] += matrix[i][right];
                }
                
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                
                int currSum = 0;
                for (int val : sum) {
                    currSum += val;
                    
                    Integer prevSum = set.ceiling(currSum - k);
                    if (prevSum != null) {
                        res = Math.max(res, currSum - prevSum);
                    }
                    
                    set.add(currSum);
                }
            }
        }
        
        return res;
    }
}