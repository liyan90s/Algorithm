class MergeSort {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }
        
        // Note: 
        // allocate the temp array space at here, instead of 
        // allocating the temp inside the merge function, which 
        // will be called many times. 
        // This can avoid time spending for each space allocating
        // and garbage collection. 
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }
    
    public void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return ;
        }
        
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        
        merge(nums, left, mid, right, temp);
    }
    
    public void merge(int[] nums, int start, int mid, int end, int[] temp) {
        int leftIndex = start;
        int rightIndex = mid + 1;
        int mergeIndex = start;
        
        while (leftIndex <= mid && rightIndex <= end) {
            if (nums[leftIndex] < nums[rightIndex]) {
                temp[mergeIndex] = nums[leftIndex];
                leftIndex++;
            } else {
                temp[mergeIndex] = nums[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }
        
        while (leftIndex <= mid) {
            temp[mergeIndex++] = nums[leftIndex++];
        }
        
        while (rightIndex <= end) {
            temp[mergeIndex++] = nums[rightIndex++];
        }
        
        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
    }
}
}