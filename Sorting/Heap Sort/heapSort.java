public class Solution {
    /*
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return ;
        }

        heapify(nums, nums.length);
        
        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            heapify(nums, i);
        }
    }
    
    public void heapify(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            buildMaxHeap(nums, i, len);
        }
    }
    
    public void buildMaxHeap(int[] nums, int k, int heapSize) {
        while (k < heapSize) {
            int maxIndex = k;
            
            if (2 * k + 1 < heapSize && nums[2 * k + 1] > nums[maxIndex]) {
                maxIndex = 2 * k + 1;
            }
            
            if (2 * k + 2 < heapSize && nums[2 * k + 2] > nums[maxIndex]) {
                maxIndex = 2 * k + 2;
            }
            
            if (k == maxIndex) {
                break ;
            }
            
            swap(nums, k, maxIndex);
            k = maxIndex;
        }
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}