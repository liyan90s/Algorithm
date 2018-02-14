public int[] sort(int[] nums) {
    if (nums == null || nums.length <= 1) {
        return nums;
    }

    quickSort(nums, 0, nums.length - 1);
    return nums;
}

public void quickSort(int[] nums, int left, int right) {
    if (left > right) {
        return ;
    }

    int pivot = nums[left];
    int lo = left + 1;
    int hi = right;

    while (lo <= hi) {
        while (lo <= hi && nums[lo] <= pivot) {
            lo++;
        }

        while (lo <= hi && nums[hi] >= pivot) {
            hi--;
        }

        if (lo <= hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }

    swap(nums, left, hi);

    if (left < hi) {
        helper(nums, left, hi);
    }

    if (lo < right) {
        helper(nums, lo, right);
    }
}

public void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
}