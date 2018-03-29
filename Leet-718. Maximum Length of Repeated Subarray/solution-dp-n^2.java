class Solution {
    public int findLength(int[] A, int[] B) {
        if (A == null || B == null) {
            return 0;
        }
        
        int res = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    memo[i][j] = 1 + memo[i + 1][j + 1];
                    res = Math.max(res, memo[i][j]);
                }
            }
        }
        
        return res;
    }
}