// Time: O(n * logM), where M is the max element in the array L.
public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        
        int left = 1, right = 0;
        for (int len : L) {
            if (len > right) {
                right = len;
            }
        }
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int pieces = countPieces(mid, L);
            
            if (pieces < k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (countPieces(right, L) >= k) {
            return right;
        }
        
        if (countPieces(left, L) >= k) {
            return left;
        }
        
        return 0;
    }
    
    public int countPieces(int cutLen, int[] L) {
        if (cutLen == 0) {
            return 0;
        }
        
        int res = 0;
        for (int woodLen : L) {
            res += woodLen / cutLen;
        }
        
        return res;
    }
}