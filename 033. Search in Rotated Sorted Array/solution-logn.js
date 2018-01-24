/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    if (nums === null || nums.length === 0) {
        return -1;
    }
    
    var left = 0;
    var right = nums.length - 1;
    
    while (left <= right) {
        var mid = left + parseInt((right - left) / 2);
        
        if (nums[mid] === target) {
            return mid;
        }
        
        if (nums[mid] > nums[left]) {
            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else if (nums[mid] < nums[left]) {
            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            left++;
        }
    }
    
    return -1;
};