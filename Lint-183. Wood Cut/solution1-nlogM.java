public class Solution {
    /**
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int res = 0;
        if (L == null || L.length == 0 || k <= 0) {
            return res;
        }
        
        int max = L[0];
        for (int i = 1; i < L.length; i++) {
            max = Math.max(max, L[i]);
        }
        
        int left = 1, right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            
            for (int i = 0; i < L.length; i++) {
                count += L[i] / mid;
            }
            
            if (count < k) {
                right = mid - 1;
            } else {
                res = Math.max(res, mid);
                left = mid + 1;
            }
        }
        
        return res;
    }
}