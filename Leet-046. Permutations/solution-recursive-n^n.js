/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permute = function(nums) {
    if (nums === null || nums.length < 2) {
        return [nums];
    }
    
    var results = [];
    backtrack(nums, results, []);
    
    return results;
};

var backtrack = function(nums, results, result) {
    if (result.length === nums.length) {
        results.push(result.slice());
    }
    
    for (var i = 0; i < nums.length; i++) {
        if (!result.includes(nums[i])) {
            result.push(nums[i]);
            backtrack(nums, results, result);
            result.pop();
        }
    }
};