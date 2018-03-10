public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapSort(int[] A) {
        if (A == null || A.length < 2) {
            return ;
        }

        heapify(A, A.length);

        for (int i = A.length - 1; i >= 0; i--) {
            // put the largest element to the end
            int temp = A[i];
            A[i] = A[0];
            A[0] = temp;

            heapify(A, i);
        }
    }

    public void heapify(int[] A, int len) {
        if (A == null || A.length == 0 || len <= 0) {
            return ;
        }
        
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(A, i, A.length);
        }
    }
    
    public void buildMaxHeap(int[] A, int k, int heapSize) {
        while (k < heapSize) {
            int maxIdx = k;
            
            if (2 * k + 1 < heapSize && A[2 * k + 1] > A[maxIdx]) {
                maxIdx = 2 * k + 1;
            }
            
            if (2 * k + 2 < heapSize && A[2 * k + 2] > A[maxIdx]) {
                maxIdx = 2 * k + 2;
            }
            
            if (k == maxIdx) {
                break ;
            }
            
            int temp = A[k];
            A[k] = A[maxIdx];
            A[maxIdx] = temp;
            
            k = maxIdx;
        }
    }
}