/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    if (nums === null || nums.length === 0) {
        return [[]];
    }
    
    var results = [[]];
    backtrack(nums, results, [], 0);
    
    return results;
};

var backtrack = function(nums, results, result, startIdx) {
    for (var i = startIdx; i < nums.length; i++) {
        result.push(nums[i]);
        results.push(result.slice());
        backtrack(nums, results, result, i + 1);
        result.pop();
    }
};