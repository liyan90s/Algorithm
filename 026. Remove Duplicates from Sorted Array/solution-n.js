/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums === null || nums.length <= 1) {
        return nums;
    }
    
    var l = 0;
    var r = 1;
    while (r < nums.length) {
        if (nums[r] !== nums[l]) {
            l++;
            nums[l] = nums[r];
        }
        r++;
    }
    
    return l + 1;
};