/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

// Time: O(n), Space: O(n)
var twoSum = function(nums, target) {
    if (nums === null) return [];
    
    var hash = [];
    for (var i = 0; i < nums.length; i++) {
        if (hash[target - nums[i]] != undefined) {
            return [i, hash[target - nums[i]]];
        } else {
            hash[nums[i]] = i;
        }
    }
    
    return [];
};