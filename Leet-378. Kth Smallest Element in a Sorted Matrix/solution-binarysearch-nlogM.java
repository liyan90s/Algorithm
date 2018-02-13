class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return 0;
        }
        
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = n - 1;
            boolean isExist = false;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                
                if (j >= 0 && matrix[i][j] == mid) {
                    isExist = true;
                }
                
                count += j + 1;
            }
            
            if (isExist && count == k) {
                return mid;
            } else if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // in the last run, if there are other elements equal to the kth smallest element in the matrix,
        // left will equal to right. And in this case, count will > k, then, right will
        // be updated to be 1 less than left index.
        // However, the left index is the kth smallest element (due to the duplicate situation.)
        return left;
    }
}