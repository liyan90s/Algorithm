/**
 * @param {number[]} nums
 * @return {number}
 */

// Time: O(logn), worst case is O(n), when nearly all elements are the same
/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function(nums) {
    if (nums === null || nums.length === 0) {
        return Number.MAX_SAFE_INTEGER;
    }
    
    var min = nums[0];
    var left = 0;
    var right = nums.length - 1;
    
    while (left <= right) {
        var mid = left + parseInt((right - left) / 2);
        
        if (nums[mid] > nums[left]) {
            min = Math.min(min, nums[left]);
            left = mid + 1;
        } else if (nums[mid] < nums[left]) {
            min = Math.min(min, nums[mid]);
            right = mid - 1;
        } else {                                    // where worst case (duplicate numbers) might happen
            min = Math.min(min, nums[left]);
            left++;
        }
    }
    
    return min;
};