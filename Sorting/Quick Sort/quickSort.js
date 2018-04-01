/*
 * @param nums  array of numbers
 * @param left  lower bound of the array to be sorted
 * @param right upper bound of the array to be sorted
 */
const quickSort = (nums, left, right) => {
    if (left > right) {
        return ;
    }

    const pivot = nums[left];
    let lo = left + 1;
    let hi = right;

    while (lo <= hi) {
        while (lo <= hi && nums[lo] < pivot) {
            lo++;
        }

        while (lo <= hi && nums[hi] > pivot) {
            hi--;
        }

        if (lo <= hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }

    swap(nums, left, hi);           // switch with index 'hi'

    if (left < hi) {
        quickSort(nums, left, hi);
    } 

    if (lo < right) {
        quickSort(nums, lo, right);
    }
}

const swap = (nums, left, right) => {
    const temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
}


// Test Case:
let nums = [1, 5, 2, 3, 7, 10, 3, 6, 1, -3];
console.log(nums);
quickSort(nums, 0, nums.length - 1)
console.log(nums);