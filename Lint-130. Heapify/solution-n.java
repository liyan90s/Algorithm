public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return ;
        }
        
        for (int i = A.length / 2; i >= 0; i--) {
            buildMinHeap(A, i, A.length);
        }
    }
    
    public void buildMinHeap(int[] A, int k, int heapSize) {
        while (k < heapSize) {
            int minIdx = k;
            
            if (2 * k + 1 < heapSize && A[2 * k + 1] < A[minIdx]) {
                minIdx = 2 * k + 1;
            }
            
            if (2 * k + 2 < heapSize && A[2 * k + 2] < A[minIdx]) {
                minIdx = 2 * k + 2;
            }
            
            if (minIdx == k) {
                break ;
            }
            
            int temp = A[minIdx];
            A[minIdx] = A[k];
            A[k] = temp;
            
            k = minIdx;
        }
    }
}