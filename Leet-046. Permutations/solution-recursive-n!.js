/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if (nums === null || nums.length < 2) {
        return [nums];
    }
    
    var results = [];
    backtrack(nums, results, 0);
    
    return results;
};

var backtrack = function(nums, results, swapIdx) {
    if (swapIdx === nums.length) {
        results.push(nums.slice());
    }
    
    for (var i = swapIdx; i < nums.length; i++) {
        swap(nums, i, swapIdx);
        backtrack(nums, results, swapIdx + 1);
        swap(nums, i, swapIdx);
    }
};

var swap = function(nums, start, end) {
    var temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
};