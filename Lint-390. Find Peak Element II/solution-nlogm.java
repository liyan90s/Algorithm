public class Solution {
    /*
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        if (A == null || A.length == 0 || A[0].length == 0) {
            return new ArrayList<>();
        }
        
        List<Integer> res = new ArrayList<>();
        int left = 1, right = A.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int col = findLargestCol(A[mid]);
            if (A[mid][col] < A[mid - 1][col]) {
                right = mid - 1;
            } else if (A[mid][col] < A[mid + 1][col]) {
                left = mid + 1;
            } else {
                res.add(mid);
                res.add(col);
                break ;
            }
        }
        
        return res;
    }
    
    public int findLargestCol(int[] arr) {
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[col]) {
                col = i;
            }
        }
        
        return col;
    }
}`