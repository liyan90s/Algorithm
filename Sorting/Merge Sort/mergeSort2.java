class MergeSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return ;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int[] helper = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            helper[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (helper[i] <= helper[j]) {
                nums[k] = helper[i];
                i++;
            } else {
                nums[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            nums[k] = helper[i];
            i++;
            k++;
        }

        // Since it's sorted in place, the right part is already in the correct place,
        // so we don't have to sort the right part
        // while (j <= right) {
        //     nums[k] = helper[j];
        //     j++;
        //     k++;            
        // }
    }
}