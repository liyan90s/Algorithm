/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var findKthLargest = function(nums, k) {
    var left = 0;
    var right = nums.length - 1;
    while (left <= right) {
        var pos = partition(nums, left, right);
        if (pos === k - 1) {
            return nums[pos];
        } else if (pos > k - 1) {
            right = pos - 1;
        } else {
            left = pos + 1;
        }
    }
    
    return nums[right];
};

var partition = function(nums, left, right) {
    var pivot = nums[left];
    var lo = left + 1;
    var hi = right;
    
    while (lo <= hi) {
        while (lo <= hi && nums[lo] >= pivot) {
            lo++;
        }
        
        while (lo <= hi && nums[hi] <= pivot) {
            hi--;
        }
        
        if (lo <= hi) {
            swap(nums, lo, hi);
            lo++;
            hi--;
        }
    }
    
    swap(nums, left, hi);
    return hi;
};

var swap = function(nums, begin, end) {
    var temp = nums[begin];
    nums[begin] = nums[end];
    nums[end] = temp;
};