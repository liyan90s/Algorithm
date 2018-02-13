/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var permuteUnique = function(nums) {
    if (nums === null || nums.length < 2) {
        return [nums];
    }
    
    nums.sort();
    var results = [];
    
    backtrack(nums, results, [], new Array(nums.length).fill(false));
    
    return results;
};

var backtrack = function(nums, results, result, used) {
    if (result.length === nums.length) {
        results.push(result.slice());
        return ;
    }
    
    for (var i = 0; i < nums.length; i++) {
        if (used[i] || i > 0 && nums[i] === nums[i - 1] && !used[i - 1]) {
            continue;
        }
        
        used[i] = true;
        result.push(nums[i]);
        backtrack(nums, results, result, used);
        result.pop();
        used[i] = false;
    }
};