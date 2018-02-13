/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if (nums === null || nums.length < 2) {
        return [nums];
    }
    
    var results = [];
    backtrack(nums, results, 0);
    
    return results;
};

var backtrack = function(nums, results, swapIdx, used) {
    if (swapIdx === nums.length) {
        results.push(nums.slice());
        return ;
    }
    
    for (var i = swapIdx; i < nums.length; i++) {
        if (noSwap(nums, swapIdx, i)) {         // if there exist same element after current swap, no need to swap again
            continue ;
        }
        
        swap(nums, i, swapIdx);
        backtrack(nums, results, swapIdx + 1);
        swap(nums, i, swapIdx);
    }
};

var noSwap = function(nums, start, end) {
    for (var i = start; i < end; i++) {
        if (nums[i] === nums[end]) {
            return true;
        }
    }
    
    return false;
};

var swap = function(nums, start, end) {
    var temp = nums[start];
    nums[start] = nums[end];
    nums[end] = temp;
};
